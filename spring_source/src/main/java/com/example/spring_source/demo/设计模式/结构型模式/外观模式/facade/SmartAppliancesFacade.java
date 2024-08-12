package com.example.spring_source.demo.设计模式.结构型模式.外观模式.facade;

import com.example.spring_source.demo.设计模式.结构型模式.外观模式.service.AirCondition;
import com.example.spring_source.demo.设计模式.结构型模式.外观模式.service.Light;
import com.example.spring_source.demo.设计模式.结构型模式.外观模式.service.TV;

//智能音箱
public class SmartAppliancesFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message) {
        if(message.contains("打开")) {
            on();
        } else if(message.contains("关闭")) {
            off();
        } else {
            System.out.println("我还听不懂你说的！！！");
        }
    }

    //起床后一键开电器
    private void on() {
        System.out.println("起床了");
        light.on();
        tv.on();
        airCondition.on();
    }

    //睡觉一键关电器
    private void off() {
        System.out.println("睡觉了");
        light.off();
        tv.off();
        airCondition.off();
    }
}