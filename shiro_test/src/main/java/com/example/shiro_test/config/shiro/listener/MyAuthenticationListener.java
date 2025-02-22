package com.example.shiro_test.config.shiro.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyAuthenticationListener implements AuthenticationListener {
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        log.info("AuthenticationListener:onSuccess");
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        log.info("AuthenticationListener:onFailure");
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        log.info("AuthenticationListener:onLogout");
    }
}
