package com.example.service.strategies.route;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.strategies.route.base.AbstractRouteStrategy;
import com.example.service.util.AsyncUtil;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.List;
import java.util.Map;

public class DirectFlowRouteStrategy extends AbstractRouteStrategy<Object> {
    @Override
    public BaseRouteContext<Void> route(BaseRouteContext<Object> routeContext) {

        List<Map.Entry<AbstractWorkflow<Object>, BaseCriteria<BaseContext<Object>>>> flows = routeContext.getFlows();
        for (Map.Entry<AbstractWorkflow<Object>, BaseCriteria<BaseContext<Object>>> flow : flows) {
            //flow.getKey().setContext(routeContext);
            AsyncUtil.getInstance().getExecutor().execute(() -> {
                flow.getKey().execute(routeContext);
            });
            //flow.getKey().execute(routeContext);
        }
        return null;
    }
}
