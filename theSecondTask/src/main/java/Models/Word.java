package Models;

import interfaces.ITextEntity;
//Leaf
public class Word implements ITextEntity<String> {
    private String content;
    private Punctuation punctuation;

    public Word(String content) {
        this.content = content;
    }

    public Word(){}

    @Override
    public void add(String textEntity) {
        //This method isn't overriden, cause this is a "Leaf" element...
    }

    @Override
    public String getChild(int i) {
        return null;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String print() {
        return new StringBuilder(content).append(punctuation.toString()).toString();
    }

    public Punctuation getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Punctuation punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return content;
    }

}
