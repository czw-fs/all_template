package com.example.springsecuritybase.config.security.login.handle;

import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.utils.JwtUtils;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败处理器
 */

@Component
@Slf4j
public class LoginFailHandler implements AuthenticationFailureHandler {


    private final JwtUtils jwtUtils;

    public LoginFailHandler(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {


        log.error(exception.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(Result.error(exception.getMessage())));
        writer.flush();
        writer.close();
    }
}
