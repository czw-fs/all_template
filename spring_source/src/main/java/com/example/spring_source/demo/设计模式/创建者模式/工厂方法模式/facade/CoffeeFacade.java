package com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.facade;

import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.Coffee;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.factory.CoffeeFactory;

public class CoffeeFacade {

    private final CoffeeFactory factory;

    public CoffeeFacade(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        return factory.createCoffee();
    }
}