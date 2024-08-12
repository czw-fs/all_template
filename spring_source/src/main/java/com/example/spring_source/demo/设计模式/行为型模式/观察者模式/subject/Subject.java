package com.example.spring_source.demo.设计模式.行为型模式.观察者模式.subject;

import com.example.spring_source.demo.设计模式.行为型模式.观察者模式.Observer.Observer;

public interface Subject {
    //增加订阅者
    public void attach(Observer observer);

    //删除订阅者
    public void detach(Observer observer);
    
    //通知订阅者更新消息
    public void notify(String message);
}