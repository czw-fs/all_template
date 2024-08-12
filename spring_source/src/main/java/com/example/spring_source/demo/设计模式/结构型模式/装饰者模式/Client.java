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

/**
 * * 抽象构件（Component）角色 ：定义一个抽象接口以规范准备接收附加责任的对象。
 * * 具体构件（Concrete  Component）角色 ：实现抽象构件，通过装饰角色为其添加一些职责。
 * * 抽象装饰（Decorator）角色 ： 继承或实现抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * * 具体装饰（ConcreteDecorator）角色 ：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 *
 * 指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式。
 */