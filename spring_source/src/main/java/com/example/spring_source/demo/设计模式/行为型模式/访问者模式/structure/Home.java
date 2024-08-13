package com.example.spring_source.demo.设计模式.行为型模式.访问者模式.structure;

import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.element.Animal;
import com.example.spring_source.demo.设计模式.行为型模式.访问者模式.visitor.Person;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Animal> nodeList = new ArrayList<Animal>();

    public void action(Person person) {
        for (Animal node : nodeList) {
            node.accept(person);
        }
    }

    //添加操作
    public void add(Animal animal) {
        nodeList.add(animal);
    }
}
