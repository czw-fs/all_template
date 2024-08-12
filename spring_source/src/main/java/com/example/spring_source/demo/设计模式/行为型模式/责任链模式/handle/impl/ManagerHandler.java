package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl;

import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.Handler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

import java.math.BigDecimal;

public class ManagerHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        System.out.println("经理处理好了");
        return request.getName().equalsIgnoreCase("bob");
    }
}