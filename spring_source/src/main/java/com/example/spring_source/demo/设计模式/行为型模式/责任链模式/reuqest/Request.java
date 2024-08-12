package com.example.spring_source.demo.设计模式.行为型模式.责任链模式.reuqest;

import java.math.BigDecimal;

public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}