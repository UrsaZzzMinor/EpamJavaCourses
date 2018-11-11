package com.epam.training.interfaces;
//Component
public interface ITextEntity<T>{
    void add(T textEntity);
    T getChild(int i);
    String getContent();
    String print();
}
