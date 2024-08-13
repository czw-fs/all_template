package com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator.impl;

import com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator.StudentIterator;
import com.example.spring_source.entity.Student;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list;
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position ++;
        return currentStudent;
    }
}