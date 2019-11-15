package com.example.service.processors.base;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.strategies.base.BaseRouteStrategy;
import com.example.service.strategies.base.RouteStrategy;
import com.example.service.strategies.route.base.AbstractRouteStrategy;

public abstract class RouteProcess<T> extends AbstractRouteProcess<BaseContext<T>, BaseRouteContext<Void>, T> {
    public RouteProcess(AbstractRouteStrategy<T> strategy) {
        super((AbstractRouteStrategy<BaseContext<T>>) strategy);
    }
}
