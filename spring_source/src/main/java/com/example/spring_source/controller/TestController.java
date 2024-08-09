package com.example.spring_source.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/")
public class TestController {


        @RequestMapping("/fs")
        public String test() {
            return "test";
        }
}
