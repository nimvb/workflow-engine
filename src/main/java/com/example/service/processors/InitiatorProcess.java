package com.example.service.processors;

import com.example.service.processors.base.BaseProcess;
import com.example.service.strategies.InitiatorStrategy;

public class InitiatorProcess extends BaseProcess {
    public InitiatorProcess() {
        super(new InitiatorStrategy());
    }
}
