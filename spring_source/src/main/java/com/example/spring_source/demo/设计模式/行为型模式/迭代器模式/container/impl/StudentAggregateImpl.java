package com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.container.impl;

import com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.container.StudentAggregate;
import com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator.StudentIterator;
import com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator.impl.StudentIteratorImpl;
import com.example.spring_source.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<Student>();  // 学生列表

    @Override
    public void addStudent(Student student) {
        this.list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}