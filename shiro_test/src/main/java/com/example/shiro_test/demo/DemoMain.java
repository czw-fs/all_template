package com.example.shiro_test.demo;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DemoMain {

    public static void main(String[] args) {
        String a = "伊利测试发放红包接口20241203154923";
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }

//    public static void testLogin2() {
//        //创建Shiro的安全管理器
//        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//        //使用自定义的数据源
//        MyRealm myRealm = new MyRealm();
//        securityManager.setRealm(myRealm);
//        //把安全管理器注入到当前的环境中
//        SecurityUtils.setSecurityManager(securityManager);
//        //获取到subject主体对象
//        Subject subject = SecurityUtils.getSubject();
//        System.out.println("认证状态：" + subject.isAuthenticated());
//        //创建令牌
//        UsernamePasswordToken token = new UsernamePasswordToken("xiaoluo", "666");
//        //执行登录操作
//        subject.login(token);
//        System.out.println("认证状态：" + subject.isAuthenticated());
//    }
//
//    public static void testLogin() {
//        //创建Shiro的安全管理器，是shiro的核心
//        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//
//        //加载shiro.ini配置，得到配置中的用户信息（账号+密码）
//        IniRealm iniRealm = new IniRealm("classpath:shiro-au.ini");
//        securityManager.setRealm(iniRealm);
//
//        //把安全管理器注入到当前的环境中
//        SecurityUtils.setSecurityManager(securityManager);
//
//        //获取subject主体对象,无论有无登录都可以获取到，但是需要属性来判断登录状态
//        Subject subject = SecurityUtils.getSubject();
//
//        System.out.println("未登录时认证状态：" + subject.isAuthenticated());
//
//        //创建令牌(携带登录用户的账号和密码)
//        UsernamePasswordToken token = new UsernamePasswordToken("xiaoluo", "666");
//
//        //执行登录操作(将用户的和 ini 配置中的账号密码做匹配)
//        subject.login(token);
//
//        System.out.println("登录成功认证状态：" + subject.isAuthenticated());
//        //登出
//        subject.logout();
//        System.out.println("退出后认证状态："+subject.isAuthenticated());
//    }
}
