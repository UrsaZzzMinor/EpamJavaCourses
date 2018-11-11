package services;

import Models.Punctuation;
import Models.Sentence;
import Models.Text;
import Models.Word;
import org.apache.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    private static Logger logger = Logger.getLogger(TextService.class);
    private static final String REGEX_FOR_SENTENCE = "[^.!?]*(.,)?[^.!?]*[.!?][\"]?";
    private static final String REGEX_FOR_WORD = "[А-яA-z0-9]+[']?[s]?";
    private Pattern parsePattern;
    private Matcher matcher;
    private Word theMostFrequentWord;
    private int max = 0;

    public Word getTheMostFrequentWord() {
        return theMostFrequentWord;
    }

    public int getMax() {
        return max;
    }

    public void parseOnElements(Text text){
        try{
            parseOnSentences(text);
            parseOnWords(text);
            parseOnPunctuation(text);
            logger.info("\"Parsing text on elements completed...\"");
        } catch (NullPointerException e){
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        }

    }

    private void parseOnSentences(Text text) {
        parsePattern = Pattern.compile(REGEX_FOR_SENTENCE);
        matcher = parsePattern.matcher(text.getContent());

        while(matcher.find()){
            String sentence = matcher.group();
            text.add(new Sentence(sentence));
        }


    }

    private void parseOnWords(Text text){
        parsePattern = Pattern.compile(REGEX_FOR_WORD);

        for (Sentence thing: text.getSentences()
        ) {
            matcher = parsePattern.matcher(thing.getContent());

            while(matcher.find()){
                String word = matcher.group();
                thing.add(new Word(word));
            }
        }
    }
//[А-яA-z0-9]+[']?[s]?[\s]*[.,!?"'-/@]*[\s]*
    private void parseOnPunctuation(Text text){
        String[] textPunctuation = text.getContent().split(REGEX_FOR_SENTENCE);
        if(textPunctuation.length > 0){
            text.setPunctuation(new Punctuation(textPunctuation[textPunctuation.length-1]));
        }
        for (Sentence thing: text.getSentences()
        ) {
            String[] punctuations = thing.getContent().split(REGEX_FOR_WORD);
            thing.setPunctuation(new Punctuation(punctuations[0]));
            for(int i = 1; i< punctuations.length; i++){
                thing.getChild(i-1).setPunctuation(new Punctuation(punctuations[i]));
            }
        }
    }

    public void findTheMostFrequentWord(Text text){
        for(Sentence sentenceForTesting: text.getSentences()){
            for(Word wordForTesting: sentenceForTesting.getWords()){
                int count = 0;
                for(Sentence sentenceForComparison: text.getSentences()) {
                    for (Word wordForComparison : sentenceForComparison.getWords()) {
                        if (wordForComparison.getContent().equalsIgnoreCase(wordForTesting.getContent())) {
                            count += 1;
                            break;
                        }
                    }
                }
                if(count > getMax()){
                    max = count;
                    theMostFrequentWord = wordForTesting;
                }
            }
        }
        try{
            logger.info(new StringBuilder("The Most frequent word is \"").append(theMostFrequentWord.getContent())
                    .append("\" that meets in ").append(max).append(" sentences."));
        } catch (NullPointerException e){
            logger.error("\"Sorry, You've got a a NullPointerException ...please, " +
                    "make sure that You've already initialized the text!");
        }
    }

    public boolean compareGivenText2Assembled(Text text){
        try{
            return text.getContent().equals(text.print());
        } catch (NullPointerException e){
            logger.error("\"Sorry, You've got a a NullPointerException ...please, " +
                    "make sure that You've already initialized the text!");
        }
        return false;
    }
}
