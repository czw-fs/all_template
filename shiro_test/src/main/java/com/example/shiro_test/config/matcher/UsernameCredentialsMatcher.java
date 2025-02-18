package com.example.shiro_test.config.matcher;

import com.example.shiro_test.model.dto.LoginUserDto;
import com.example.shiro_test.model.dto.UserInfo;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

@Component
public class UsernameCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        LoginUserDto loginUserDto = (LoginUserDto) token;
        UserInfo dbUserInfo = (UserInfo) info;

        String loginPassword = loginUserDto.getPassword();
        String dbPassword = dbUserInfo.getPassword();

        boolean success = loginPassword.equals(dbPassword);

        if(success){
            dbUserInfo.setPassword(null);
            return true;
        }
        return false;
    }
}
