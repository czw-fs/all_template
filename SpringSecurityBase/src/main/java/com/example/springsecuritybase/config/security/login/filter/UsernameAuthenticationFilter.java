package com.example.springsecuritybase.config.security.login.filter;

import com.example.springsecuritybase.config.security.login.dto.CustomUsernamePasswordAuthenticationToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Map;

/**
 * 获取请求体中用户名和密码，创建SpringSecurity需要的AbstractAuthenticationToken对象，并交给springsecurity进行验证
 */

public class UsernameAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public UsernameAuthenticationFilter(AntPathRequestMatcher pathRequestMatcher,
                                        AuthenticationManager authenticationManager,
                                        AuthenticationSuccessHandler authenticationSuccessHandler,
                                        AuthenticationFailureHandler authenticationFailureHandler) {
        super(pathRequestMatcher);
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(authenticationSuccessHandler);
        setAuthenticationFailureHandler(authenticationFailureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        // 提取请求数据
        Map<String, Object> requestMapData = new ObjectMapper().readValue(request.getInputStream(), Map.class);

        String username = requestMapData.get("username").toString();
        String password = requestMapData.get("password").toString();

        System.out.println(username + "-" + password);

        CustomUsernamePasswordAuthenticationToken authenticationToken = new CustomUsernamePasswordAuthenticationToken();
        authenticationToken.setUsername(username);
        return null;
    }
}
