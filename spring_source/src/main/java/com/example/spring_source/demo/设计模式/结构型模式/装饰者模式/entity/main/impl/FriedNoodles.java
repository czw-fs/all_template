package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.impl;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;

//炒面
public class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(12, "炒面");
    }

    public float cost() {
        return getPrice();
    }
}