package com.example.springsecuritybase.config.security.handle;

import com.example.springsecuritybase.modules.common.model.Result;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限不足时，会执行这个方法。将失败原因告知客户端
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpStatus.FORBIDDEN.value());

            PrintWriter writer = response.getWriter();
            writer.print(new Gson().toJson(Result.error("无权访问")));
            writer.flush();
            writer.close();
    }
}
