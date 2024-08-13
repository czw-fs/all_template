package com.example.spring_source.demo.设计模式.行为型模式.中介者模式.mediator.impl;

import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.Person;
import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.impl.HouseOwner;
import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.colleague.impl.Tenant;
import com.example.spring_source.demo.设计模式.行为型模式.中介者模式.mediator.Mediator;
import lombok.Data;

//中介机构
@Data
public class MediatorStructure extends Mediator {
    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public void constact(String message, Person person) {
        if (person == houseOwner) {          //如果是房主，则租房者获得信息
            tenant.getMessage(message);
        } else {       //反正则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}

