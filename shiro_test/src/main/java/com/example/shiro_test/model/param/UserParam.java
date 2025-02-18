package com.example.shiro_test.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserParam {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
