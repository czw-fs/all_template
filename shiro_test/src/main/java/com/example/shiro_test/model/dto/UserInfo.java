package com.example.shiro_test.model.dto;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

@Data
public class UserInfo implements AuthenticationInfo {
    private Long id;
    private String username;
    private String password;
    private String addr;


    @Override
    public PrincipalCollection getPrincipals() {
        // 返回一个包含用户唯一标识（如用户名）的PrincipalCollection
        return new SimplePrincipalCollection(this, getClass().getName());
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }
}
