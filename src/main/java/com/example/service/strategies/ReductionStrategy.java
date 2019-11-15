package com.example.service.strategies;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

public class ReductionStrategy implements BaseProcessStrategy<Integer, BaseContext<Integer>> {

    @Override
    public BaseContext<Integer> execute(BaseContext<Integer> data) {
        data.setContextData(data.getContextData() - 1);
        return data;
    }
}
