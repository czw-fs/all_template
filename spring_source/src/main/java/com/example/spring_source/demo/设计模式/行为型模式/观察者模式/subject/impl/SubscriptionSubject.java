package com.example.spring_source.demo.设计模式.行为型模式.观察者模式.subject.impl;

import com.example.spring_source.demo.设计模式.行为型模式.观察者模式.Observer.Observer;
import com.example.spring_source.demo.设计模式.行为型模式.观察者模式.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {
    //储存订阅公众号的微信用户
    private List<Observer> weixinUserlist = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserlist) {
            observer.update(message);
        }
    }
}