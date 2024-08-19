package com.example.springsecuritybase;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@MapperScan({
    "com.example.springsecuritybase.modules.System.user.mapper",
    "com.example.springsecuritybase.modules.System.dict.mapper",
    "com.example.springsecuritybase.modules.System.menu.mapper",
    "com.example.springsecuritybase.modules.System.role.mapper",
    "com.example.springsecuritybase.modules.test.mapper"
})
@SpringBootApplication
@Slf4j
public class SpringSecurityBaseApplication {

    public static void main(String[] args) {
        log.info("开始启动");
        SpringApplication.run(SpringSecurityBaseApplication.class, args);
        log.info("启动成功");
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("本项目注册的所有MapperBean");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.stream(beanNames).filter(item -> item.endsWith("Mapper")).sorted().forEach(System.out::println);
        };
    }

}
