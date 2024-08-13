package com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Cat;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Dog;

public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}