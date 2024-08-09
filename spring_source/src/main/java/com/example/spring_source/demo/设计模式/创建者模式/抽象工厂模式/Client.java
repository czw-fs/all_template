package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式;


import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.facade.FactoryFacade;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.impl.GreenFactory;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.impl.RedFactory;

public class Client {
    public static void main(String[] args) {

        FactoryFacade greenFacade = new FactoryFacade(new GreenFactory());
        greenFacade.createPaper();
        greenFacade.createPen();

        FactoryFacade redFacade = new FactoryFacade(new RedFactory());
        redFacade.createPaper();
        redFacade.createPen();
    }
}

/**
 * A:
 *当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
 *
 * B:
 * 当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。
 */
