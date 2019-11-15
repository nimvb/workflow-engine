package com.example.service.processors;

import com.example.model.base.BaseContext;
import com.example.service.processors.base.BaseProcess;
import com.example.service.strategies.PrintStrategy;

public class PrintProcess extends BaseProcess<Object, BaseContext<Void>> {
    public PrintProcess() {
        super(new PrintStrategy());
    }
}
