package com.example.shiro_test.model.dto;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

@Data
public class LoginUserDto implements AuthenticationToken {
    private String username;
    private String password;


    @Override
    public String getPrincipal() {
        return this.username;
    }

    @Override
    public String getCredentials() {
        return this.password;
    }
}
