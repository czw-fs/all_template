package com.example.shiro_test.config.realms;

import com.example.shiro_test.mapper.UserMapper;
import com.example.shiro_test.model.dto.JWTToken;
import com.example.shiro_test.model.dto.UserInfo;
import com.example.shiro_test.model.entities.User;
import com.example.shiro_test.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JWTRealm extends AuthorizingRealm {

    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    // 让shiro支持我们自定义的token，即如果传入的token时JWTToken则放行
    // 必须重写不然shiro会报错
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    // 检验权限时调用
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("添加权限");
        return new UserInfo();
    }

    // 认证和鉴权时调用
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = ((JWTToken) authenticationToken).getToken();
        if (!jwtUtil.verifyToken(token)) {
            throw new AuthenticationException("该token非法，可能被篡改或过期");
        }
        Long userId = jwtUtil.getUserId(token);
        User user = userMapper.selectById(userId);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        userInfo.setAddr(user.getAddr());

        return userInfo;
    }
}
