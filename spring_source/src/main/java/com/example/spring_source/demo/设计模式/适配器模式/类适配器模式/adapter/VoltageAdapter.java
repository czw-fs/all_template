package com.example.spring_source.demo.设计模式.适配器模式.类适配器模式.adapter;

import com.example.spring_source.demo.设计模式.适配器模式.类适配器模式.service.impl.Voltage220VImpl;
import com.example.spring_source.demo.设计模式.适配器模式.类适配器模式.service.IVoltage5VService;


public class VoltageAdapter extends Voltage220VImpl implements IVoltage5VService {

    @Override
    public int output5V() {
        //获取到220V电压
        int srcV = output220V();
        int dstV = srcV/44; //转成5V
        return dstV;
    }
}
