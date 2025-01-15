package com.example.thirdapi.moyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/fs")
    public String fs() {
        return "fs";
    }
}
