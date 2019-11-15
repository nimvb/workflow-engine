package com.example.service.processors.route;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.processors.base.RouteProcess;
import com.example.service.strategies.base.BaseRouteStrategy;
import com.example.service.strategies.base.RouteStrategy;
import com.example.service.strategies.route.base.AbstractRouteStrategy;

public class StringRouteProcess extends RouteProcess<String> {

    public StringRouteProcess(AbstractRouteStrategy<String> strategy) {
        super(strategy);
    }
}
