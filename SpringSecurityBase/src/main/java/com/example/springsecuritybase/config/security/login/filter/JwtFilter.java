package com.example.springsecuritybase.config.security.login.filter;

import com.example.springsecuritybase.config.security.login.dto.CustomUsernamePasswordAuthenticationToken;
import com.example.springsecuritybase.config.security.login.dto.UserLoginInfo;
import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.utils.JwtUtils;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    public JwtFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++");
        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("token");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {
            UserLoginInfo userLoginInfo = jwtUtils.getUserLoginInfoFromJwt(token);
            if(userLoginInfo == null){
                response.getWriter().write(new Gson().toJson(Result.error(HttpStatus.UNAUTHORIZED.value(),"token无效")));
                doFilter(request, response, chain);
                return;
            }

            if(jwtUtils.isTokenExpired(token)){
                response.getWriter().write(new Gson().toJson(Result.error(HttpStatus.UNAUTHORIZED.value(),"token过期")));
                doFilter(request, response, chain);
                return;
            }

            CustomUsernamePasswordAuthenticationToken authenticationToken = new CustomUsernamePasswordAuthenticationToken();
            authenticationToken.setCurrentUser(userLoginInfo);
            authenticationToken.setAuthenticated(true);//token有效，认证成功

            //验证成功，设置security上下文，无需验证
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            chain.doFilter(request, response);
            System.out.println("圣诞节分厘卡圣诞节发");
        }
    }
}
