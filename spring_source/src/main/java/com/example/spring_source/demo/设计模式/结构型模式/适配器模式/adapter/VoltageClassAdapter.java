package com.example.spring_source.demo.设计模式.结构型模式.适配器模式.adapter;

import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.impl.Voltage220VImpl;
import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.IVoltage5VService;

/**
 * 类适配器模式
 */
public class VoltageClassAdapter extends Voltage220VImpl implements IVoltage5VService {

    @Override
    public int output5V() {
        System.out.println("使用类适配器");
        //  获取到220V电压
        int srcV = output220V();
        int dstV = srcV/44; //转成5V
        return dstV;
    }
}
