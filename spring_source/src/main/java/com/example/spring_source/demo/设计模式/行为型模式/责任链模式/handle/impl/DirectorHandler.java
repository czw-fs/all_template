package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl;

import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.Handler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

import java.math.BigDecimal;

public class DirectorHandler implements Handler {

    public Boolean process(Request request) {
        // 如果超过10000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        System.out.println("负责人处理好了");
        return request.getName().equalsIgnoreCase("bob");
    }
}
