package com.example.spring_source.demo.设计模式.行为型模式.策略模式.strategy.impl;

import com.example.spring_source.demo.设计模式.行为型模式.策略模式.strategy.Strategy;

//为春节准备的促销活动A
public class StrategyA implements Strategy {

    public void show() {
        System.out.println("买一送一");
    }
}