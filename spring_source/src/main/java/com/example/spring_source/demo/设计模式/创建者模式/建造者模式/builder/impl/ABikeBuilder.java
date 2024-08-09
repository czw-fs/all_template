package com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.impl;

import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.Builder;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity.Bike;

//摩拜单车Builder类
public class ABikeBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("A车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("A车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}