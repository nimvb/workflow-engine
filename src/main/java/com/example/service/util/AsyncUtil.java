package com.example.service.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncUtil {


    private static final AsyncUtil instance = new AsyncUtil();

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    private AsyncUtil(){}

    public static AsyncUtil getInstance() {
        return instance;
    }


    public ExecutorService getExecutor(){
        return executor;
    }
}
