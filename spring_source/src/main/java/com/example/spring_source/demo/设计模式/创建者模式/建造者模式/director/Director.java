package com.example.spring_source.demo.设计模式.创建者模式.建造者模式.director;

import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.Builder;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity.Bike;

//指挥者类
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike create() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}