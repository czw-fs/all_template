package com.example.spring_source.demo.设计模式.行为型模式.中介者模式.mediator;

import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.Person;

//抽象中介者
public abstract class Mediator {
    //申明一个联络方法
    public abstract void constact(String message, Person person);
}