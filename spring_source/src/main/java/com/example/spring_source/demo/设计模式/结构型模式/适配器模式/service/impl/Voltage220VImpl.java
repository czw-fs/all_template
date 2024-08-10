package com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.impl;

import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.Voltage220VService;

//被适配的类 Voltage220V.java
public class Voltage220VImpl implements Voltage220VService {

    //输出220V的电压
    public int output220V() {
        return 220;
    }
}
