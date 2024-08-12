package com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式;

import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.entity.Coffee;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.factory.impl.AmericanCoffeeFactory;
import com.example.spring_source.demo.设计模式.创建者模式.工厂方法模式.stroe.CoffeeStore;

public class Client {
    public static void main(String[] args) {
        //CoffeeStore
        CoffeeStore coffeeStore = new CoffeeStore(new AmericanCoffeeFactory());

        // 调用具体实现工厂创建的实体类对象的方法
        Coffee coffee = coffeeStore.orderCoffee();

    }
}

/**
 * A:
 * 知道具体工厂就可创建产品，无须知道产品的具体创建过程；
 * 增加新产品时，只添加具体工厂类和具体产品类即可，无须对原工厂进行任何修改，满足开闭原则；
 *
 * B:
 * 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
 */
