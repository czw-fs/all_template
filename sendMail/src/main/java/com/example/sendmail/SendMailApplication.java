package com.example.sendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;



@EnableAsync
@SpringBootApplication
public class SendMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendMailApplication.class, args);
    }

}
