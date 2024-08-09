package com.example.spring_source.demo.设计模式.适配器模式.类适配器模式;

import com.example.spring_source.demo.设计模式.适配器模式.类适配器模式.adapter.VoltageAdapter;
import com.example.spring_source.demo.设计模式.适配器模式.类适配器模式.entity.Phone;

public class Client {
    public static void main(String[] args) {

        Phone phone = new Phone();

        //将220V电压转换成5V电压
        VoltageAdapter voltageAdapter = new VoltageAdapter();
        //充电
        phone.charging(voltageAdapter);
    }
}