package com.example.model.base;

import java.util.HashMap;

public abstract class AbstractAttributeContext<T> {
    protected HashMap<String, T> attributes;


    public AbstractAttributeContext(){
        this.attributes = new HashMap<>();
    }

    public AbstractAttributeContext(AbstractAttributeContext<T> other){
        this.attributes = other.attributes;
    }

    public HashMap<String, T> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, T> attributes) {
        this.attributes = attributes;
    }


}
