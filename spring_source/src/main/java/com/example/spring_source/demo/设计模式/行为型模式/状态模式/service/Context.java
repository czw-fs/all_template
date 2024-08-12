package com.example.spring_source.demo.设计模式.行为型模式.状态模式.service;

import com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state.State;

public class Context {
    //持有一个State类型的对象实例
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        //转调state来处理
        state.handle(sampleParameter);
    }
}