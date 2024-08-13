package com.example.springsecuritybase.TestController;

import com.example.springsecuritybase.config.security.login.dto.UserLoginDto;
import com.example.springsecuritybase.modules.common.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PostMapping("/user/login")
    public Result<String> login(UserLoginDto userLoginDto){

        System.out.println(userLoginDto);

        //认证

        //认证成功返回token

        String token = "测试toke";

        return Result.success(token);
    }
}
