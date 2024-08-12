package com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state.impl;

import com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state.State;

public class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateA handle ：" + sampleParameter);
    }

}