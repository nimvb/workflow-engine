package com.example.service.processors;

import com.example.model.base.BaseContext;
import com.example.service.processors.base.BaseProcess;
import com.example.service.strategies.ConvertToUppercaseStrategy;

public class ConvertToUppercaseProcess extends BaseProcess<String, BaseContext<String>> {
    public ConvertToUppercaseProcess() {
        super(new ConvertToUppercaseStrategy());
    }
}
