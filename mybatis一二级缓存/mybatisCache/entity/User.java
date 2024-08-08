package com.example.spring_source.demo.mybatisCache.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private LocalDate time;

}