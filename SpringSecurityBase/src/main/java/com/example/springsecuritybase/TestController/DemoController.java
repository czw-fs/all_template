package com.example.springsecuritybase.TestController;

import com.example.springsecuritybase.modules.System.service.UserService;
import com.example.springsecuritybase.modules.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/fs")
    public Result<Object> login(){
        System.out.println("hello world！");
        return Result.success();
    }
}
