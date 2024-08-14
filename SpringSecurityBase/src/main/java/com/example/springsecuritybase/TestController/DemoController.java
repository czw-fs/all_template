package com.example.springsecuritybase.TestController;

import com.example.springsecuritybase.config.security.SecurityUtils;
import com.example.springsecuritybase.config.security.login.dto.UserLoginDto;
import com.example.springsecuritybase.config.security.login.dto.UserLoginInfo;
import com.example.springsecuritybase.modules.System.service.UserService;
import com.example.springsecuritybase.modules.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @PostMapping("/fs")
    public Result<Object> login(UserLoginDto userLoginDto){

        UserLoginInfo userLoginInfo = SecurityUtils.getUserLoginInfo();
        System.out.println(userLoginInfo);

        return Result.success(userLoginInfo);
    }
}
