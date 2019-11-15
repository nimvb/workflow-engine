package com.example.model.base;

public abstract class AbstractContext<T,TT> extends AbstractAttributeContext<TT>  {

    protected T contextData;
    protected boolean dropped;

    public AbstractContext(){
        super();
        this.contextData = null;
    }

    public AbstractContext(T contextData){
        super();
        this.contextData = contextData;
    }

    public AbstractContext(AbstractAttributeContext<TT> attributeContext){
        super(attributeContext);
        this.contextData = null;
    }

    public AbstractContext(AbstractContext<T,TT> other){
        super(other);
        this.dropped = other.dropped;
        this.contextData = other.contextData;
    }

    public T getContextData() {
        return contextData;
    }

    public void setContextData(T contextData) {
        this.contextData = contextData;
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }
}
