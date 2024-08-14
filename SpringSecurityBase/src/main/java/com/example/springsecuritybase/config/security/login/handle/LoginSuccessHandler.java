package com.example.springsecuritybase.config.security.login.handle;

import com.example.springsecuritybase.config.security.login.dto.UserLoginInfo;
import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.utils.JwtUtils;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserLoginInfo currentUser)) {
            throw new RuntimeException("登陆认证成功后，返回的Object对象必须是：UserLoginInfo！");
        }

        //todo refreshToken

        currentUser.setSessionId(UUID.randomUUID().toString());
        String token = jwtUtils.createJwt(currentUser);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(Result.success("登录成功",token)));
        writer.flush();
        writer.close();
    }
}
