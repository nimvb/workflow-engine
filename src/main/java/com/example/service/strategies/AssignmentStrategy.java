package com.example.service.strategies;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

public class AssignmentStrategy implements BaseProcessStrategy<Object, BaseContext<Object>> {

    private Object value;

    public AssignmentStrategy(Object value){
        this.value = value;
    }

    @Override
    public BaseContext<Object> execute(BaseContext<Object> data) {
        data.setContextData(value);
        return data;
    }
}
