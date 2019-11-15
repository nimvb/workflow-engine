package com.example.model.base;

import com.example.service.criteria.base.BaseCriteria;
import com.example.service.workflow.base.AbstractWorkflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRouteContext<T, TT> extends AbstractContext<T, TT> {

    protected List<Map.Entry<AbstractWorkflow<T>, BaseCriteria<BaseContext<T>>>> flows;

    public AbstractRouteContext(){
        super();
        this.flows = new ArrayList<>();
    }

    public AbstractRouteContext(AbstractRouteContext<T,TT> other){
        super(other);
        this.flows = other.flows;
    }

    public AbstractRouteContext(AbstractContext<T,TT> other){
        super(other);
        this.flows = new ArrayList<>();
    }

    public AbstractRouteContext(T data){
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
