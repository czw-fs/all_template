package com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.service.impl;

import com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.service.SellTickets;

//火车站  火车站具有卖票功能，所以需要实现SellTickets接口
public class TrainStation implements SellTickets {

    public void sell() {
        System.out.println("火车站卖票");
    }
}