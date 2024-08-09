package com.example.spring_source.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//注册配置类
@Configuration
//指定读取的配置文件路径
@PropertySource("classpath:application.yml")
//指定读取的配置前缀
@ConfigurationProperties(prefix = "spring.application")
@Data
public class DemoProperTies {

    private String name;


}
