package Models;

import interfaces.ITextEntity;
//Leaf
public class Punctuation implements ITextEntity<String> {
    private String content;

    public Punctuation(String content){
        this.setContent(content);
    }

    public Punctuation(){}

    @Override
    public String toString() {
        return getContent();
    }

    @Override
    public void add(String textEntity) {
        //This method isn't overriden, cause this is a "Leaf" element...
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getChild(int i) {
        return null;
    }

    @Override
    public String print() {
        return null;
    }

}
