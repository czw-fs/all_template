package com.example.shiro_test.model.entities;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String addr;
}