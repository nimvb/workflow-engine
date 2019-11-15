package com.example.service.strategies;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

public class PrintStrategy implements BaseProcessStrategy<Object, BaseContext<Void>> {

    @Override
    public BaseContext<Void> execute(BaseContext<Object> data) {
        System.out.println(data.getContextData());
        return null;
    }
}
