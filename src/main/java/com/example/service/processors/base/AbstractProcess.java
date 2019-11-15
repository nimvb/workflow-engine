package com.example.service.processors.base;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;
import com.example.service.strategies.base.ProcessStrategy;

import java.util.Optional;

public abstract class AbstractProcess<I, O extends BaseContext> {

    protected BaseProcessStrategy<I, O> strategy;

    public AbstractProcess(BaseProcessStrategy<I, O> strategy) {
        this.strategy =  strategy;
    }

    public Optional<BaseContext<?>> execute(BaseContext<I> data) {
        BaseContext<O> result = strategy.execute(data);
        if (result != null) {
            return Optional.ofNullable(result);
        }
        return Optional.empty();
    }
}
