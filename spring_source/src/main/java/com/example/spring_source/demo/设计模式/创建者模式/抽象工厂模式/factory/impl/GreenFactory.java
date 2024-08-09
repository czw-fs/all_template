package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.impl;

import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.impl.GreenPaper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.Pen;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.Paper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.impl.GreenPen;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.AbstractFactory;

public class GreenFactory implements AbstractFactory {

    @Override
    public Paper createPaper() {
        return new GreenPaper();
    }

    @Override
    public Pen createPen() {
        return new GreenPen();
    }
}