package com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.impl;

import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.IVoltage5VService;

public class PhoneServiceImpl {

    //充电
    public void charging(IVoltage5VService iVoltage5V) {
        if(iVoltage5V.output5V() == 5) {
            System.out.println("电压5V，可以充电");
        }else if(iVoltage5V.output5V() > 5) {
            System.out.println("电压大于5V，无法充电");
        }
    }
}
