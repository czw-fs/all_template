package com.example.shiro_test.config.realms;

import com.example.shiro_test.model.dto.LoginUserDto;
import com.example.shiro_test.model.entities.User;
import com.example.shiro_test.mapper.UserMapper;
import com.example.shiro_test.model.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyRealm extends AuthenticatingRealm {
    private final UserMapper userMapper;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof LoginUserDto;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //根据用户名查询用户信息
        User user = userMapper.selectByName(token.getPrincipal().toString());
        if(user == null) {
            throw new UnknownAccountException("没有查询到改用户信息");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        userInfo.setAddr(user.getAddr());

        return userInfo;
    }
}