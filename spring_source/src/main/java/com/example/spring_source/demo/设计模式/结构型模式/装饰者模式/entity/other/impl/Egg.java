package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.impl;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;
import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.Decorator;

//鸡蛋配料
public class Egg extends Decorator {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    public float cost() {
        return getPrice() + getFastFood().cost(); // 应该调用 cost() 方法，而不是 getPrice()
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc() + " + " + super.getDesc();
    }
}