package com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.impl;

import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.Builder;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity.Bike;

//ofo单车Builder类
public class BBikeBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("B车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("B车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}