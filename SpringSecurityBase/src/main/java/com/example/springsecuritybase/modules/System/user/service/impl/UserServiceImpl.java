package com.example.springsecuritybase.modules.System.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.user.convert.UserConvert;
import com.example.springsecuritybase.modules.System.user.mapper.UserMapper;
import com.example.springsecuritybase.modules.System.user.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.user.model.entities.User;
import com.example.springsecuritybase.modules.System.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    private final UserMapper userMapper;
    private final UserConvert userConvert;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username).eq(User::getIsDeleted,false));
    }

    @Override
    public void createUser(UserDto userDto) {
        String encode = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encode);

        User user = userConvert.UserDtoToUser(userDto);

        userMapper.insert(user);
    }

    @Override
    public Page<UserDto> selectPage(UserDto userDto) {

        return null;
    }
}
