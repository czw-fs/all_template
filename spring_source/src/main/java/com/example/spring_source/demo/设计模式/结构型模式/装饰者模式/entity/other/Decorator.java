package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;
import lombok.Data;

//配料类
@Data
public abstract class Decorator extends FastFood {

    private FastFood fastFood;

    public Decorator(FastFood fastFood, float price, String desc) {
        super(price,desc);
        this.fastFood = fastFood;
    }
}