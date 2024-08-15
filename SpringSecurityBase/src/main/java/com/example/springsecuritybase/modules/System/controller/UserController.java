package com.example.springsecuritybase.modules.System.controller;


import com.example.springsecuritybase.modules.System.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.service.UserService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    public Result<Void> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return Result.success();
    }
}
