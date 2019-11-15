package com.example.model.route.base;

import com.example.model.base.AbstractRouteContext;
import com.example.model.base.CloneableContext;

import java.util.ArrayList;

public class BaseRouteContext<T> extends AbstractObjectRouteContext<T> {

    public BaseRouteContext() {
        super();
    }

    public BaseRouteContext(T data) {
        super(data);
        this.flows = new ArrayList<>();
    }

    public BaseRouteContext(BaseRouteContext<T> context) {
        super(context);
    }

    @Override
    public BaseRouteContext<T> clone() {
        BaseRouteContext<T> routeContext = new BaseRouteContext<>(this);
        routeContext.flows = new ArrayList<>(this.flows);
        return routeContext;
    }
}
