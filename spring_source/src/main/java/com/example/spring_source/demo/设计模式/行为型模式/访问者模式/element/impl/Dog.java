package com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.Animal;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.Person;

public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，汪汪汪！！！");
    }
}

