package com.example.service.strategies;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

public class InitiatorStrategy implements BaseProcessStrategy<Object,BaseContext<Object>> {

    @Override
    public BaseContext<Object> execute(BaseContext<Object> data) {
        return data;
    }
}
