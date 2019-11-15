package com.example.service.strategies;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

public class ConvertToUppercaseStrategy implements BaseProcessStrategy<String, BaseContext<String>> {

    @Override
    public BaseContext<String> execute(BaseContext<String> data) {
        data.setContextData(data.getContextData().toUpperCase());
        return data;
    }
}
