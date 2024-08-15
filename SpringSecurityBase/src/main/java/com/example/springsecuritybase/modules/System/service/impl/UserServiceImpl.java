package com.example.springsecuritybase.modules.System.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.mapper.user.UserMapper;
import com.example.springsecuritybase.modules.System.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.model.entities.User;
import com.example.springsecuritybase.modules.System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
    private final UserMapper userMapper;
//    private final UserConvert userConvert;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username).eq(User::getIsDeleted,false));
    }

    @Override
    public void createUser(UserDto userDto) {
//        User user = userConvert.UserDtoToUser(userDto);
//        userMapper.insert(user);
    }
}
