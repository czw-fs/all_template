package com.example.shiro_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {
        "com.example.shiro_test.mapper"
})
public class ShiroTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroTestApplication.class, args);
    }
}
