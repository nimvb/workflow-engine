package com.example.service.criteria.base;

public interface Criteria<I, O> {

    O filter(I context);
}
