package com.example.mybatis_mul_source.controller;

import com.example.mybatis_mul_source.entity.Student;
import com.example.mybatis_mul_source.mapper.StudentMapper;
import com.example.mybatis_mul_source.mapper2.StudentMapper2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final StudentMapper studentMapper;
    private final StudentMapper2 studentMapper2;

    @RequestMapping("/fs")
    public String fs() {
        Student student = studentMapper.selectUser();
        System.out.println(student);

        Student student2 = studentMapper2.selectUser();
        System.out.println(student2);
        return "fs";
    }
}
