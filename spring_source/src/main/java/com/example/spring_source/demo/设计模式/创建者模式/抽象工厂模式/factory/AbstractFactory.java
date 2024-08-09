package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.factory;

import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.paper.Paper;
import com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式.entity.pen.Pen;

//创建工厂的接口
public interface AbstractFactory {
    Paper createPaper();

    Pen createPen();
}  
