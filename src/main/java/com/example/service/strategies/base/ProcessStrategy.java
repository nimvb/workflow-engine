package com.example.service.strategies.base;

public interface ProcessStrategy<I,O> {

    O execute(I data);

}
