package com.example.spring_source.main;

import com.example.spring_source.entity.Student;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DemoMain  {

//;生成测试代码

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("张三"));
        students.add(new Student());
        students.add(new Student("王五"));

       String coordinatorName = coordinatorName = students.stream().map(Student::getName).filter(StringUtils::isNotBlank).collect(Collectors.joining("、"));
        System.out.println("coordinatorName = " + coordinatorName);

    }
}

