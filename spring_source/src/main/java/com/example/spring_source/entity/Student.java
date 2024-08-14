package com.example.spring_source.entity;


public class Student {

    public String getName() {
        return name;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
