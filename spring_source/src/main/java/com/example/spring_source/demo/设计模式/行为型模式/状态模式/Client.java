package com.example.spring_source.demo.设计模式.行为型模式.状态模式;

import com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.Context;
import com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state.State;
import com.example.spring_source.demo.设计模式.行为型模式.状态模式.service.state.impl.ConcreteStateB;

public class Client {

    public static void main(String[] args){
        //创建状态
        State state = new ConcreteStateB();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
    }
}

/**
 * 将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为。
 * 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
 *
 *
 * 环境（Context）角色：也称为上下文，它定义了客户程序需要的接口，维护一个当前状态，并将与状态相关的操作委托给当前状态对象来处理。
 * 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为。
 * 具体状态（Concrete  State）角色：实现抽象状态所对应的行为。
 */