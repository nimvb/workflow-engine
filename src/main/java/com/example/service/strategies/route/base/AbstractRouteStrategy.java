package com.example.service.strategies.route.base;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.strategies.base.BaseRouteStrategy;
import com.example.service.strategies.base.RouteStrategy;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRouteStrategy<T> implements BaseRouteStrategy<T, Void, T> {

    private List<Map.Entry<AbstractWorkflow<T>, BaseCriteria<BaseContext<T>>>> flows = new ArrayList<>();


    @Override
    public RouteStrategy<T, BaseRouteContext<Void>, T> linkFlow(AbstractWorkflow<T> workflow, BaseCriteria<BaseContext<T>> criteria) {
        flows.add(new AbstractMap.SimpleEntry<>(workflow, criteria));
        return this;
    }

    @Override
    public BaseRouteContext<Void> execute(BaseContext<T> data) {
        BaseRouteContext<T> routeContext = new BaseRouteContext<>();
        routeContext.setContextData(data.getContextData());
        routeContext.setFlows(flows);
        return route(routeContext);
    }

    public abstract BaseRouteContext<Void> route(BaseRouteContext<T> routeContext);

}
