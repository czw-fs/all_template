package com.example.spring_source.demo.设计模式.结构型模式.桥接模式;

import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.system.OperatingSystem;
import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.system.impl.Windows;
import com.example.spring_source.demo.设计模式.结构型模式.桥接模式.service.video.impl.AVIFile;

//测试类
public class Client {
    public static void main(String[] args) {
        OperatingSystem os = new Windows(new AVIFile());
        os.play("战狼3");
    }
}

/**
 * * 抽象化（Abstraction）角色 ：定义抽象类，并包含一个对实现化对象的引用。
 * * 扩展抽象化（Refined  Abstraction）角色 ：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * * 实现化（Implementor）角色 ：定义实现化角色的接口，供扩展抽象化角色调用。
 * * 具体实现化（Concrete Implementor）角色 ：给出实现化角色接口的具体实现。
 *
 桥接模式就是一种将抽象（概念）和实现（具体操作）分开的设计模式。
 就像你可以用不同的遥控器控制不同品牌的电视机一样，
 桥接模式让你可以把操作（遥控器）和具体实现（电视机）分开，、
 这样你可以随意更换遥控器或者电视机，而不需要修改其他部分。
 */