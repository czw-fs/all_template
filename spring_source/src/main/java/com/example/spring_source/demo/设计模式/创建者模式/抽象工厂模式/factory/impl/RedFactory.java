package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.impl;

import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.Paper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.impl.RedPaper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.Pen;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.impl.RedPen;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory.AbstractFactory;

public class RedFactory implements AbstractFactory {

    @Override
    public Paper createPaper() {
        return new RedPaper();
    }

    @Override
    public Pen createPen() {
        return new RedPen();
    }
}