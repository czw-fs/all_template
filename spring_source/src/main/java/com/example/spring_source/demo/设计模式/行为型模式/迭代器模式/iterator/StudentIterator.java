package com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator;

import com.example.spring_source.entity.Student;

public interface StudentIterator {
    boolean hasNext();
    Student next();
}