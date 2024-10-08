package com.example.spring_source.demo.设计模式.行为型模式.命令模式.command.impl;

import com.example.spring_source.demo.设计模式.行为型模式.命令模式.command.Command;
import com.example.spring_source.demo.设计模式.行为型模式.命令模式.receiver.Receiver;

public class ConcreteCommand implements Command {
    //持有相应的接收者对象
    private Receiver receiver = null;
    /**
     * 构造方法
     */
    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }

}