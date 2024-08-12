package com.example.spring_source.demo.设计模式.结构型模式.组合模式.Component.impl;

import com.example.spring_source.demo.设计模式.结构型模式.组合模式.Component.MenuComponent;

public class MenuItem extends MenuComponent {

    public MenuItem(String name,int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 1; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);
    }
}