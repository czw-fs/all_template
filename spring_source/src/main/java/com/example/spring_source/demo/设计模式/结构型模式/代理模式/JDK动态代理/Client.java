package com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理;

import com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.proxy.ProxyFactory;
import com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.service.SellTickets;

//测试类
public class Client {
    public static void main(String[] args) {
        //获取代理对象
        ProxyFactory factory = new ProxyFactory();
        
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}