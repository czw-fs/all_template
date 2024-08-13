package com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.Person;

public interface Animal {
    void accept(Person person);
}