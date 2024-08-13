package com.example.springsecuritybase.config.security;

import com.example.springsecuritybase.config.security.handle.AuthenticationExceptionHandler;
import com.example.springsecuritybase.config.security.handle.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationExceptionHandler authenticationExceptionHandler = new AuthenticationExceptionHandler();
    private final CustomAccessDeniedHandler customAccessDeniedHandler = new CustomAccessDeniedHandler();

    @Bean
    public SecurityFilterChain loginFilterChain(HttpSecurity http) throws Exception {
        disableSomeHttpSetting(http);
        // 使用securityMatcher限定当前配置作用的路径
        http.securityMatcher("/**")
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());


        return http.build();
    }
    /**
     * 禁用不必要的默认filter，处理异常响应内容
     * 禁用SpringSecurity默认filter。这些filter都是非前后端分离项目的产物，用不上.
     */
    private void disableSomeHttpSetting(HttpSecurity http) throws Exception {
        /**
         *          yml配置文件将日志设置DEBUG模式，就能看到加载了哪些filter
         *          logging:
         *             level:
         *                org.springframework.security: DEBUG
         *          表单登录/登出、session管理、csrf防护等默认配置，如果不disable。会默认创建默认filter
         */
        http.formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)// requestCache用于重定向，前后端分析项目无需重定向，requestCache也用不上
                .requestCache(cache -> cache.requestCache(new NullRequestCache()))
                .anonymous(AbstractHttpConfigurer::disable);// 无需给用户一个匿名身份

        // 处理 SpringSecurity 异常响应结果。响应数据的结构，改成业务统一的JSON结构。不要框架默认的响应结构
        http.exceptionHandling(exceptionHandling ->
                exceptionHandling
                        // 认证失败异常
                        .authenticationEntryPoint(authenticationExceptionHandler)
                        // 鉴权失败异常
                        .accessDeniedHandler(customAccessDeniedHandler)
        );
        // 其他未知异常. 尽量提前加载。
//        http.addFilterBefore(globalSpringSecurityExceptionHandler, SecurityContextHolderFilter.class);
    }
}