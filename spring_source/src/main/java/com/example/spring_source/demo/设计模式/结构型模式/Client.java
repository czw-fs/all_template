package com.example.spring_source.demo.设计模式.结构型模式;

import com.example.spring_source.demo.设计模式.结构型模式.外观模式.facade.SmartAppliancesFacade;

//测试类
public class Client {
    public static void main(String[] args) {
        //创建外观对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        //客户端直接与外观对象进行交互
        facade.say("打开家电");
        facade.say("关闭家电");
    }
}

/**
 *
 * * 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *
 * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 *适配器模式分为类适配器模式和对象适配器模式，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 */