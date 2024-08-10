package com.example.spring_source.demo.设计模式.结构型模式.适配器模式.adapter;

import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.IVoltage5VService;
import com.example.spring_source.demo.设计模式.结构型模式.适配器模式.service.Voltage220VService;

/**
 * 对象适配器
 */
public class VoltageObjectAdapter implements IVoltage5VService {

    private Voltage220VService voltage220VService;// 聚合关系（不再是继承）

    // 通过构造器传入一个Voltage220V的实例
    public VoltageObjectAdapter(Voltage220VService voltage220VService) {
        this.voltage220VService = voltage220VService;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (null != voltage220VService) {
            int src = voltage220VService.output220V(); // 获取220V电压
            System.out.println("使用对象适配器进行适配");
            dstV = src / 44;
            System.out.println("适配完成，输出电压为：" + dstV + "V");
        }
        return dstV;
    }


}
