package com.example.spring_source.demo.设计模式.行为型模式.命令模式.invoker;

import com.example.spring_source.demo.设计模式.行为型模式.命令模式.command.Command;

public class Invoker {
    /**
     * 持有命令对象
     */
    private Command command = null;
    /**
     * 构造方法
     */
    public Invoker(Command command){
        this.command = command;
    }
    /**
     * 行动方法
     */
    public void action(){
        
        command.execute();
    }
}