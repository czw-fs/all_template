package org.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplicationClient1 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient1.class,args);
    }
}