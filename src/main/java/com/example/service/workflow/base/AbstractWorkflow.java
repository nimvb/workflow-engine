package com.example.service.workflow.base;

import com.example.model.base.BaseContext;
import com.example.service.processors.InitiatorProcess;
import com.example.service.processors.base.AbstractProcess;
import com.example.service.processors.base.BaseProcess;
import com.example.service.processors.base.RouteProcess;

import java.util.Optional;

public abstract class AbstractWorkflow<T> {

    private BaseContext<T> context;
    private InitiatorProcess initiatorProcessorStrategy;

    public AbstractWorkflow() {
        this.context = new BaseContext<>();
        this.initiatorProcessorStrategy = new InitiatorProcess();
    }

    public void setContext(BaseContext<T> context){
        this.context = context;

    }

    public void execute(T data) {
        context.setContextData(data);
        BaseContext<T> result = (BaseContext<T>) this.initiatorProcessorStrategy.execute(context).get();
        if(result != null) {
            context.setContextData(result.getContextData());
        }
    }

    public void execute(BaseContext<T> context){
        this.context = context;
        BaseContext<T> result = (BaseContext<T>) this.initiatorProcessorStrategy.execute(context).get();
        if(result != null){
            context.setContextData(result.getContextData());
        }
    }

    public Object getResult() {
        return context.getContextData();
    }

    public InitiatorProcess getInitiatorProcessorStrategy() {
        return initiatorProcessorStrategy;
    }

    public BaseProcess getLastProcessor() {
        BaseProcess current = initiatorProcessorStrategy;
        do {
            if (current.getNextProcess() == null || current.getNextProcess() instanceof RouteProcess)
                break;
            current = (BaseProcess) current.getNextProcess();
        } while (true);
        return current;
    }

    public Optional<RouteProcess> getRouteProcessor() {
        AbstractProcess current = initiatorProcessorStrategy;
        do {
            if (current == null)
                break;
            if (current instanceof BaseProcess) {
                current = ((BaseProcess) current).getNextProcess();
            }
            if (current instanceof RouteProcess) {
                break;
            }

        } while (true);
        if (current == null) {
            return Optional.empty();
        }
        return Optional.of(((RouteProcess) current));
    }
}
