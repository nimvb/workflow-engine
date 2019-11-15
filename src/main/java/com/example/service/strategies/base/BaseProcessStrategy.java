package com.example.service.strategies.base;

import com.example.model.base.BaseContext;

public interface BaseProcessStrategy<I,O extends BaseContext> extends ProcessStrategy<BaseContext<I>,O> {
}
