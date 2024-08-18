package com.example.springsecuritybase.modules.test.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DemoMain {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
