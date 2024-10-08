package com.example.springsecuritybase.config.security.login.dto;

import lombok.Data;

/**
 * 接受前端传参
 */

@Data
public class UserLoginDto {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
