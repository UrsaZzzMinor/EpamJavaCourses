package com.epam.training.Models;

import com.epam.training.interfaces.ITextEntity;
import java.util.ArrayList;
import java.util.List;

//Composite
public class Sentence implements ITextEntity<Word> {
    private List<Word> words = new ArrayList<>();
    private String content;
    private Punctuation punctuation;

    public Sentence(String content) {
        this.content = content;
    }

    public Sentence(){}

    public List<Word> getWords() {
        return words;
    }

    public Punctuation getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Punctuation punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public void add(Word textEntity) {
        getWords().add(textEntity);
    }

    @Override
    public Word getChild(int i) {
        return getWords().get(i);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder(punctuation.print());
        for (Word word: words) {
            stringBuilder.append(word.print());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return content;
    }

}
