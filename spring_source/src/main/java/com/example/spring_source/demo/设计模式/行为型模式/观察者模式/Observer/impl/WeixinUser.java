package com.example.spring_source.demo.设计模式.行为型模式.观察者模式.Observer.impl;

import com.example.spring_source.demo.设计模式.行为型模式.观察者模式.Observer.Observer;

public class WeixinUser implements Observer {
    // 微信用户名
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}