package com.example.shiro_test.config.shiro;

import com.example.shiro_test.config.shiro.matcher.JwtCredentialsMatcher;
import com.example.shiro_test.config.shiro.matcher.UsernameCredentialsMatcher;
import com.example.shiro_test.config.shiro.realms.JWTRealm;
import com.example.shiro_test.config.shiro.realms.UsernameRealm;
import com.example.shiro_test.filter.JWTFilter;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ShiroConfig {
    private final JWTRealm jwtRealm;
    private final UsernameRealm usernameRealm;

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        jwtRealm.setCredentialsMatcher(new JwtCredentialsMatcher());
        usernameRealm.setCredentialsMatcher(new UsernameCredentialsMatcher());

        List<Realm> realmList = new ArrayList<>();
        realmList.add(jwtRealm);
        realmList.add(usernameRealm);

        defaultWebSecurityManager.setRealms(realmList);

        // 关闭session
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        defaultSubjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        defaultWebSecurityManager.setSubjectDAO(defaultSubjectDAO);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //添加过滤器
        shiroFilterFactoryBean.setFilters(getFilters());
        //过滤规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());

        // 设置无权限时跳转url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        return shiroFilterFactoryBean;
    }

    /**
     * 添加过滤器
     */
    public Map<String, Filter> getFilters(){
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        return filterMap;
    }

    /**
     * 过滤规则
     */
    public Map<String,String> getFilterChainDefinitionMap(){
        Map<String, String> filterRuleMap = new HashMap<>();
        // 访问 登录接口时直接放行
        filterRuleMap.put("/userLogin","anon");
        // 其他所有请求都通过JWT Filter
        filterRuleMap.put("/**", "jwt");
        return filterRuleMap;
    }

    /**
     * 添加注解支持，如果不加的话很有可能注解失效
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
//
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(defaultWebSecurityManager);
        return advisor;
    }


}
