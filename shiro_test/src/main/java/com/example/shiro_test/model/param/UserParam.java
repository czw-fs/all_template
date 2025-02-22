package com.example.shiro_test.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserParam {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
