package com.example.spring_source.demo.设计模式.结构型模式.代理模式.CGLIB动态代理;

import com.example.spring_source.demo.设计模式.结构型模式.代理模式.CGLIB动态代理.entity.TrainStation;
import com.example.spring_source.demo.设计模式.结构型模式.代理模式.CGLIB动态代理.factory.ProxyFactory;

//测试类
public class Client {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //获取代理对象
        TrainStation proxyObject = factory.getProxyObject();

        proxyObject.sell();
    }
}