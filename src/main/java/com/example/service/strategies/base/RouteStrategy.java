package com.example.service.strategies.base;

import com.example.model.base.BaseContext;
import com.example.model.route.base.BaseRouteContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.workflow.base.AbstractWorkflow;

public interface RouteStrategy<I, O extends BaseRouteContext, TF> extends BaseProcessStrategy<I, O> {
    RouteStrategy<I, O, TF> linkFlow(AbstractWorkflow<TF> workflow, BaseCriteria<BaseContext<I>> criteria);
}
