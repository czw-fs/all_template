package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.impl;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;


//炒饭
public class FriedRice extends FastFood {

    public FriedRice() {
        super(10, "炒饭");
    }

    public float cost() {
        return getPrice();
    }
}