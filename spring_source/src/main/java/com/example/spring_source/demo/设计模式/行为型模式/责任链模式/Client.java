package com.example.spring_source.demo.设计模式.行为型模式.责任链模式;

import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.HandlerChain;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl.CEOHandler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl.DirectorHandler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle.impl.ManagerHandler;
import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());

        //创造请求
        Request request1 = new Request("Bob", new BigDecimal(200));
        Request request2 = new Request("Bob", new BigDecimal(2000));
        Request request3 = new Request("Bob", new BigDecimal(20000));

        //处理请求
        chain.process(request1);
        chain.process(request2);
        chain.process(request3);
    }
}
