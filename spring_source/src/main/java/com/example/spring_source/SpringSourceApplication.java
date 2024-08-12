package com.example.spring_source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSourceApplication.class, args);
        System.out.println("启动成功");
    }

}
