package com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder;

import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity.Bike;

// 抽象 builder 类
public abstract class Builder {

    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike createBike();
}