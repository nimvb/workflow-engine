package com.example.model.base;

public interface CloneableContext<T extends CloneableContext> {

    public T clone();
}
