package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl;

import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.Handler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

public class CEOHandler implements Handler {

    public Boolean process(Request request) {
        //都能处理
        System.out.println("CEO处理好了");
        return request.getName().equalsIgnoreCase("bob");
    }
}
