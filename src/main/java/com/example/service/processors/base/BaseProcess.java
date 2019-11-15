package com.example.service.processors.base;

import com.example.model.base.BaseContext;
import com.example.service.strategies.base.BaseProcessStrategy;

import java.util.Optional;

public abstract class BaseProcess<I, O extends BaseContext> extends AbstractProcess<I, O> {

    protected AbstractProcess<O, ?> nextProcess;

    public BaseProcess(BaseProcessStrategy<I, O> strategy) {
        super(strategy);
    }

    public BaseProcess<O, ?> link(BaseProcess next) {
        this.nextProcess = next;
        return (BaseProcess<O, ?>) this.nextProcess;
    }

    public AbstractRouteProcess link(RouteProcess next) {
        this.nextProcess = next;
        return (RouteProcess) this.nextProcess;
    }

    @Override
    public Optional<BaseContext<?>> execute(BaseContext<I> data) {
        Optional<BaseContext<?>> result = super.execute(data);
        if (nextProcess != null) {
            nextProcess.execute((BaseContext<O>) result.orElse(new BaseContext<>()));
        }
        return result;
    }


    public AbstractProcess<O, ?> getNextProcess() {
        return nextProcess;
    }
}
