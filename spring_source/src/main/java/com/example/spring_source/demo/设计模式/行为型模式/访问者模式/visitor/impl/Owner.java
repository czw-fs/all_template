package com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.impl;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Cat;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Dog;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.Person;

public class Owner implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂食狗");
    }
}