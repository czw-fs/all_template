package com.example.springsecuritybase.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class MyCustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 这里是实际的过滤逻辑
        System.out.println("MyCustomFilter is processing the request");

        // 继续执行过滤链中的下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化逻辑（如果有）
    }

    @Override
    public void destroy() {
        // 销毁逻辑（如果有）
    }
}