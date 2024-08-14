package com.example.springsecuritybase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({
    "com.example.springsecuritybase.modules.System.mapper.user"
})
@SpringBootApplication
public class SpringSecurityBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBaseApplication.class, args);
        System.out.println("启动成功");
    }

}
