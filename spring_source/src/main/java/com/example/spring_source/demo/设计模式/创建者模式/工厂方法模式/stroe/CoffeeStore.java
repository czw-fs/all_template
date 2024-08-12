package com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.stroe;

import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.Coffee;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.factory.CoffeeFactory;

public class CoffeeStore {

    private final CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        return factory.createCoffee();
    }
}