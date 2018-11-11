package com.epam.training.Models;

import com.epam.training.interfaces.ITextEntity;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
//Composite
public class Text implements ITextEntity<Sentence> {
    private static Logger logger = Logger.getLogger(Text.class);
    private List<Sentence> sentences = new ArrayList<>();
    private String content;
    private Punctuation punctuation;

    public Text(String content){
        this.content = content;
    }

    public Text(){}

    public Punctuation getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Punctuation punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public void add(Sentence textEntity) {
        getSentences().add(textEntity);
    }

    @Override
    public Sentence getChild(int i) {
        return getSentences().get(i);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String print() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Sentence sentence : sentences) {
                stringBuilder.append(sentence.print());
            }
            return stringBuilder.append(punctuation.print()).toString();
        } catch (NullPointerException e){
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        }

        return null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return content;
    }

}
