package com.example.spring_source.demo.设计模式.结构型模式.享元模式.entity;

public abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color) {
        System.out.println("方块形状：" + this.getShape() + " 颜色：" + color);
    }
}