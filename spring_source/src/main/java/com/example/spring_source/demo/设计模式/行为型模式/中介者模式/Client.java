package com.example.spring_source.demo.设计模式.行为型模式.中介者模式;

import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.impl.HouseOwner;
import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.impl.Tenant;
import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.mediator.impl.MediatorStructure;

public class Client {
    public static void main(String[] args) {
        //一个房主、一个租房者、一个中介机构
        MediatorStructure mediator = new MediatorStructure();

        //房主和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.constact("需要租三室的房子");
        houseOwner.constact("我这有三室的房子，你需要租吗？");
    }
}

/**
 *
 * * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * * 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * * 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 * 又叫调停模式，定义一个中介角色来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。
 *
 *
 * 一对多关联转变为一对一的关联
 * 当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护。
 */
