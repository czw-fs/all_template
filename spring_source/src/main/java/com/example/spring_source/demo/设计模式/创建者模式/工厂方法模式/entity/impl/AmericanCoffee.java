package com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.impl;

import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.Coffee;

public class AmericanCoffee implements Coffee {


    @Override
    public void addMilk() {
        System.out.println("AmericanCoffee加入牛奶");
    }
}
