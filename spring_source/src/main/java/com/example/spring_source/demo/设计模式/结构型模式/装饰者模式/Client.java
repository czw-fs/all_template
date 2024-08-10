package com.example.spring_source.demo.设计模式.结构型模式.装饰者模式;

import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.FastFood;
import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.main.impl.FriedNoodles;
import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.impl.Bacon;
import com.example.spring_source.demo.设计模式.结构型模式.装饰者模式.entity.other.impl.Egg;

//测试类
public class Client {
    public static void main(String[] args) {

        //点一份炒面 + 2培根 + 鸡蛋
        FastFood food2 = new FriedNoodles();
        food2 = new Bacon(food2);
        food2 = new Bacon(food2);
        food2 = new Egg(food2);
        //花费的价格
        System.out.println(food2.getDesc() + " " + food2.cost() + "元");
    }
}