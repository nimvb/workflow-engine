package com.example.service.strategies.route;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.criteria.base.Criteria;
import com.example.service.strategies.base.RouteStrategy;
import com.example.service.strategies.route.base.AbstractRouteStrategy;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.List;
import java.util.Map;

public class StringFlowRouteStrategy extends AbstractRouteStrategy<String> {
    @Override
    public BaseRouteContext<Void> route(BaseRouteContext<String> routeContext) {
        List<Map.Entry<AbstractWorkflow<String>, BaseCriteria<BaseContext<String>>>> flows = routeContext.getFlows();
        for (Map.Entry<AbstractWorkflow<String>, BaseCriteria<BaseContext<String>>> flow : flows) {
            BaseContext<String> filter = flow.getValue().filter(routeContext);
            flow.getKey().execute(filter.getContextData());
        }
        return null;
    }

}
