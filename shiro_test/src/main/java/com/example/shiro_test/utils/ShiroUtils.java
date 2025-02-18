package com.example.shiro_test.utils;

import com.example.shiro_test.model.dto.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.security.Principal;

public class ShiroUtils {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Object getPrincipal() {
        return getSubject().getPrincipal();
    }

    public static UserInfo getUserInfo() {
        return (UserInfo)getPrincipal();
    }

    public static Long getUserId() {
        return getUserInfo().getId();
    }

    private static String getUserName() {
        return getUserInfo().getUsername();
    }
}
