package com.example.spring_source.config;

import com.example.spring_source.entity.Person;
import com.example.spring_source.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Autowired
    private Student student;

    @Bean
    public Person createPerson() {

        System.out.println(createStudent());


        System.out.println(createStudent());
        System.out.println(createStudent());
        System.out.println(createStudent());
        System.out.println(student);

        System.out.println(student == createStudent());

        return new Person();
    }



    @Bean
    public Student createStudent() {
        return new Student();
    }

}
