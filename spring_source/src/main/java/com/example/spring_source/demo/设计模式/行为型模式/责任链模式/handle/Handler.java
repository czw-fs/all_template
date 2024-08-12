package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.handle;


import com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest.Request;

public interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
	Boolean process(Request request);
}