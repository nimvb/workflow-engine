package com.example.service.processors;

import com.example.model.base.BaseContext;
import com.example.service.processors.base.BaseProcess;
import com.example.service.strategies.AssignmentStrategy;
import com.example.service.strategies.base.BaseProcessStrategy;

public class AssignmentProcess extends BaseProcess<Object, BaseContext<Object>> {

    public AssignmentProcess(Object value) {
        super(new AssignmentStrategy(value));
    }

}
