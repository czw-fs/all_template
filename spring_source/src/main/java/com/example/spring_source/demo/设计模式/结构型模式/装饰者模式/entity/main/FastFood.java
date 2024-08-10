package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main;

import lombok.Data;

//快餐接口
@Data
public abstract class FastFood {
    private float price;
    private String desc;

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public abstract float cost();  //获取价格
}