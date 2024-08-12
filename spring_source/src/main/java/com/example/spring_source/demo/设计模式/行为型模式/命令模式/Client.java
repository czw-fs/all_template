package com.example.spring_source.demo.设计模式.行为型模式.命令模式;

import com.example.spring_source.demo.设计模式.行为型模式.命令模式.command.Command;
import com.example.spring_source.demo.设计模式.行为型模式.命令模式.command.impl.ConcreteCommand;
import com.example.spring_source.demo.设计模式.行为型模式.命令模式.invoker.Invoker;
import com.example.spring_source.demo.设计模式.行为型模式.命令模式.receiver.Receiver;

public class Client {

    public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();

        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);

        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);

        //执行方法
        invoker.action();
    }

}

/**
 * 命令模式是对命令的封装。命令模式把发出命令的责任和执行命令的责任分割开，委派给不同的对象。
 *
 * 每一个命令都是一个操作：请求的一方发出请求要求执行一个操作；接收的一方收到请求，并执行操作。
 * 命令模式允许请求的一方和接收的一方独立开来，使得请求的一方不必知道接收请求的一方的接口，
 * 更不必知道请求是怎么被接收，以及操作是否被执行、何时被执行，以及是怎么被执行的。
 */