package com.example.springsecuritybase;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({
    "com.example.springsecuritybase.modules.System.mapper.user"
})
@SpringBootApplication
@Slf4j
public class SpringSecurityBaseApplication {

    public static void main(String[] args) {
        log.info("开始启动");
        SpringApplication.run(SpringSecurityBaseApplication.class, args);
        log.info("启动成功");
    }

}
