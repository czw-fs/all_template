package com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.factory.impl;

import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.Coffee;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.impl.AmericanCoffee;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.factory.CoffeeFactory;

public class AmericanCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}