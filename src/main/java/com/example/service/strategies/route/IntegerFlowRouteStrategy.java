package com.example.service.strategies.route;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.strategies.route.base.AbstractRouteStrategy;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.List;
import java.util.Map;

public class IntegerFlowRouteStrategy extends AbstractRouteStrategy<Integer> {
    @Override
    public BaseRouteContext<Void> route(BaseRouteContext<Integer> routeContext) {
        List<Map.Entry<AbstractWorkflow<Integer>, BaseCriteria<BaseContext<Integer>>>> flows = routeContext.getFlows();

        for (Map.Entry<AbstractWorkflow<Integer>, BaseCriteria<BaseContext<Integer>>> flow : flows) {
            BaseContext<Integer> filter = flow.getValue().filter(routeContext);
            if (!filter.isDropped()) {

                flow.getKey().execute(filter.getContextData());
            }
//            if (!filter.isDropped()) {
//            }
        }
        return null;
    }
}
