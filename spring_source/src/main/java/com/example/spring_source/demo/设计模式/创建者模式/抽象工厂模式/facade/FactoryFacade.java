package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.facade;

import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.Paper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.Pen;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.AbstractFactory;

public class FactoryFacade {

    private final AbstractFactory factory;

    public FactoryFacade(AbstractFactory factory) {
        this.factory = factory;
    }

    public Paper createPaper() {
        return factory.createPaper();
    }

    public Pen createPen() {
        return factory.createPen();
    }


}