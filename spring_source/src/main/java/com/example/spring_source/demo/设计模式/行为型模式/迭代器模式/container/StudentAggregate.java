package com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.container;

import com.example.spring_source.demo.设计模式.行为型模式.迭代器模式.iterator.StudentIterator;
import com.example.spring_source.entity.Student;

public interface StudentAggregate {
    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}