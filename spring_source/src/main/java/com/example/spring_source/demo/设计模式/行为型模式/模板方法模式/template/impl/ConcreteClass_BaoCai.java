package com.example.spring_source.demo.设计模式.行为型模式.模板方法模式.template.impl;

import com.example.spring_source.demo.设计模式.行为型模式.模板方法模式.template.AbstractClass;

public class ConcreteClass_BaoCai extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是辣椒");
    }
}