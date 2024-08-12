package com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state;

public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}