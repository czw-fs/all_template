package com.example.shiro_test.service;



import com.example.shiro_test.mapper.UserMapper;
import com.example.shiro_test.model.Result;
import com.example.shiro_test.model.dto.LoginUserDto;
import com.example.shiro_test.model.dto.UserInfo;
import com.example.shiro_test.model.param.UserParam;
import com.example.shiro_test.utils.JwtUtil;
import com.example.shiro_test.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;

    public Result<String> login(UserParam param) {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername(param.getUsername());
        loginUserDto.setPassword(param.getPassword());
        
        SecurityUtils.getSubject().login(loginUserDto);

        Long userId = ShiroUtils.getUserId();
        if(userId != null) {
            String jwtToken = jwtUtil.createJwtToken(userId);
            return Result.success(jwtToken);
        }

        return Result.error(500,"登录失败");
    }
}