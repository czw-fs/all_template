package com.example.shiro_test.controller;

import com.example.shiro_test.config.shiro.contanst.NormalConstant;
import com.example.shiro_test.mapper.UserMapper;
import com.example.shiro_test.model.Result;
import com.example.shiro_test.model.entities.User;
import com.example.shiro_test.model.param.UserParam;
import com.example.shiro_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping(NormalConstant.loginUrl)
    public Result<String> userLogin(UserParam param) {
        return userService.login(param);
    }

    @RequiresRoles("admin")
    @GetMapping("/fs")
    public void fs() {
        User user = userMapper.selectByName("张三");
        System.out.println(user);
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
