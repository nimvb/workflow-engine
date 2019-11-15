package com.example.service.processors.base;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.strategies.base.BaseProcessStrategy;
import com.example.service.strategies.route.base.AbstractRouteStrategy;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.Optional;

public abstract class AbstractRouteProcess<I, O extends BaseRouteContext<Void>, T> extends AbstractProcess<I, O> {

    //protected AbstractWorkflow workflow;
    protected AbstractRouteStrategy<I> routeStrategy;

    public AbstractRouteProcess(AbstractRouteStrategy<I> strategy) {
        super((BaseProcessStrategy<I, O>) strategy);
        this.routeStrategy = strategy;
    }


    @Override
    public Optional<BaseContext<?>> execute(BaseContext<I> data) {
        Optional<BaseContext<?>> result = super.execute(data);
        return result;
    }

    public AbstractRouteProcess linkFlow(AbstractWorkflow next, BaseCriteria criteria) {
        this.routeStrategy.linkFlow(next, criteria);
        return this;
    }
}
