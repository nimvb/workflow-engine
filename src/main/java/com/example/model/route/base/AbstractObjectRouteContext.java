package com.example.model.route.base;

import com.example.model.base.AbstractContext;
import com.example.model.base.BaseContext;
import com.example.service.criteria.base.BaseCriteria;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractObjectRouteContext<T> extends BaseContext<T> {

    protected List<Map.Entry<AbstractWorkflow<T>, BaseCriteria<BaseContext<T>>>> flows;

    public AbstractObjectRouteContext(){
        super();
        this.flows = new ArrayList<>();
    }

    public AbstractObjectRouteContext(AbstractObjectRouteContext<T> other){
        super(other);
        this.flows = other.flows;
    }

    public AbstractObjectRouteContext(AbstractContext<T,Object> other){
        super(other);
        this.flows = new ArrayList<>();
    }

    public AbstractObjectRouteContext(T data){
        super(data);
        this.flows = new ArrayList<>();
    }

    public List<Map.Entry<AbstractWorkflow<T>, BaseCriteria<BaseContext<T>>>> getFlows() {
        return flows;
    }

    public void setFlows(List<Map.Entry<AbstractWorkflow<T>, BaseCriteria<BaseContext<T>>>> flows) {
        this.flows = flows;
    }
}
