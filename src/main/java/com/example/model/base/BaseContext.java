package com.example.model.base;

import java.util.HashMap;

public class BaseContext<T> extends AbstractContext<T, Object> implements CloneableContext<BaseContext<T>> {


    public BaseContext() {
        super();
    }

    public BaseContext(T data) {
        super(data);
    }

    public BaseContext(AbstractAttributeContext<Object> attributeContext) {
        super(attributeContext);
    }

    public BaseContext(BaseContext<T> context) {
        super(context);
    }

    @Override
    public BaseContext<T> clone() {
        BaseContext<T> context = new BaseContext<>(this);
        context.attributes = new HashMap<>();
        context.attributes.putAll(this.attributes);
        return context;
    }
}
