package com.example.spring_source.demo.设计模式.结构型模式.适配器模式;

import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.adapter.VoltageClassAdapter;
import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.adapter.VoltageObjectAdapter;
import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.impl.PhoneServiceImpl;
import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.impl.Voltage220VImpl;

public class Client {
    public static void main(String[] args) {

        test1();
        System.out.println("------------");
        test2();

    }

    //类适配器
    public static void test1(){
        PhoneServiceImpl phone = new PhoneServiceImpl();

        //将220V电压转换成5V电压
        VoltageClassAdapter voltageClassAdapter = new VoltageClassAdapter();
        //充电
        phone.charging(voltageClassAdapter);
    }

    //对象适配器
    public static void test2(){
        PhoneServiceImpl phone = new PhoneServiceImpl();

        //将220V电压转换成5V电压
        VoltageObjectAdapter voltageClassAdapter = new VoltageObjectAdapter(new Voltage220VImpl());
        //充电
        phone.charging(voltageClassAdapter);
    }
}