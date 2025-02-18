package com.example.shiro_test.model.dto;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Collection;
import java.util.List;

@Data
public class UserInfo implements AuthenticationInfo, AuthorizationInfo {
    private Long id;
    private String username;
    private String password;
    private String addr;
    private Collection<String> roles;
    private Collection<String> stringPermissions;


    @Override
    public PrincipalCollection getPrincipals() {
        // 返回一个包含用户唯一标识（如用户名）的PrincipalCollection
        return new SimplePrincipalCollection(this, getClass().getName());
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Collection<String> getRoles() {
        return List.of("admin");
    }

    @Override
    public Collection<String> getStringPermissions() {
        return List.of();
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return List.of();
    }
}
