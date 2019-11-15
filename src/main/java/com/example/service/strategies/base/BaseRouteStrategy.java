package com.example.service.strategies.base;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;

public interface BaseRouteStrategy<I,O,T> extends RouteStrategy<I, BaseRouteContext<O>,T> {
}
