package com.example.spring_source.demo.设计模式.行为型模式.访问者模式;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Cat;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.impl.Dog;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.structure.Home;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.impl.Owner;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.impl.Someone;

public class Client {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());

        Owner owner = new Owner();
        home.action(owner);

        Someone someone = new Someone();
        home.action(someone);
    }
}

/**
 * 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作。
 */