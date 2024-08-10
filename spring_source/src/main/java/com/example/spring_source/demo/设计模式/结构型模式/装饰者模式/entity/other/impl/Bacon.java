package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.impl;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;
import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.Decorator;

//培根配料
public class Bacon extends Decorator {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc() + " + " + super.getDesc();
    }
}