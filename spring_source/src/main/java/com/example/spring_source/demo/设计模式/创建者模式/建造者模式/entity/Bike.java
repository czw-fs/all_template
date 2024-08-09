package com.example.spring_source.demo.设计模式.创建者模式.建造者模式.entity;

import lombok.Data;

//自行车类
@Data
public class Bike {
    private String frame;
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}