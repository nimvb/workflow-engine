package com.example.service.processors;

import com.example.model.base.BaseContext;
import com.example.service.processors.base.BaseProcess;
import com.example.service.strategies.ReductionStrategy;

public class ReductionProcess extends BaseProcess<Integer, BaseContext<Integer>> {
    public ReductionProcess() {
        super(new ReductionStrategy());
    }
}
