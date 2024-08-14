package com.example.springsecuritybase.config.security.login.provider;

import com.example.springsecuritybase.config.security.login.dto.CustomUsernamePasswordAuthenticationToken;
import com.example.springsecuritybase.config.security.login.dto.UserLoginInfo;
import com.example.springsecuritybase.modules.System.model.entities.User;
import com.example.springsecuritybase.modules.System.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 使用用户名密码登录方式的认证逻辑
 */

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserServiceImpl userService;

    public UsernamePasswordAuthenticationProvider() {}

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserLoginInfo userLoginInfo = checkPassword(authentication);

        CustomUsernamePasswordAuthenticationToken token = new CustomUsernamePasswordAuthenticationToken();
        token.setCurrentUser(userLoginInfo);

        token.setAuthenticated(true); // 认证通过，这里一定要设成true
        return token;
    }

    private UserLoginInfo checkPassword(Authentication authentication) {
        // 获取之前在UsernameAuthenticationFilter封装的对象
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        User user = userService.selectUserByUsername(username);

        if (user == null || !new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            /**
             * 抛出异常后后，AuthenticationFailureHandler的实现类会处理这个异常。
             */
            throw new BadCredentialsException("用户名或密码不正确");
        }
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo
                .setUserId(user.getId())
                .setUsername(user.getUsername())
        ;
        return userLoginInfo;
        /**
         * 这里security会将UserLoginInfo对象封装到Authentication对象中，并设置到当前线程的security的上下文中。接下载就可以使用SecurityContext了
         */
    }

    @Override
    public boolean supports(Class<?> authentication) {
        /**
         *authentication 是否是 UsernameAuthentication 或其子类的实例。如果是，它会返回 true，否则返回 false。
         */
        return authentication.isAssignableFrom(CustomUsernamePasswordAuthenticationToken.class);
    }
}
