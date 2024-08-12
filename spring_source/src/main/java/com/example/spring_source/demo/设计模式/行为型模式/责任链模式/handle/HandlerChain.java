package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle;

import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    // 持有所有Handler:
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    public boolean process(Request request) {


        // 依次调用每个Handler:
        for (Handler handler : handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                return r;
            }
        }

        throw new RuntimeException("Could not handle request: " + request);
    }
}