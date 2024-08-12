package com.example.spring_source.demo.设计模式.结构型模式.享元模式;

import com.example.spring_source.demo.设计模式.结构型模式.享元模式.factory.BoxFactory;

public class Client {
    public static void main(String[] args) {
        BoxFactory boxFactory = new BoxFactory();
        boxFactory.getBox("I").display("黄色");
    }
}

/**
 * 运用共享技术来有效地支持大量细粒度对象的复用。
 * 它通过共享已经存在的对象来大幅度减少需要创建的对象数量、
 * 避免大量相似对象的开销，从而提高系统资源的利用率。
 *
 * - 极大减少内存中相似或相同对象数量，节约系统资源，提供系统性能
 * - 享元模式中的外部状态相对独立，且不影响内部状态
 *
 * 这里的形状就是内部状态，颜色就是外部状态
 *
 * 缺点
 * 为了使对象可以共享，需要将享元对象的部分状态外部化，分离内部状态和外部状态，使程序逻辑复杂
 */