package com.example.spring_source.demo.设计模式.创建者模式.建造者模式;

import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.impl.ABikeBuilder;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.builder.impl.BBikeBuilder;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.director.Director;
import com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity.Bike;

/**
 * 将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰
 * 建造者模式很容易进行扩展。有新的需求，新建一个造者类就可以完成，基本上不用修改之前已经测试通过的代码，因此也就不会对原有功能引入风险。符合开闭原则。
 *
 * 造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
 *
 * @Accessors(chain = true)就是建造者模式的一种实现
 */

//测试类
public class Client {
    public static void main(String[] args) {
        Director aDirector = new Director(new ABikeBuilder());
        Director bDirector = new Director(new BBikeBuilder());

        Bike aBike = aDirector.create();
        Bike bBike = bDirector.create();

        System.out.println("aBike = " + aBike);
        System.out.println("bBike = " + bBike);
    }

}