package com.example.springsecuritybase.modules.System.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.user.convert.UserConvert;
import com.example.springsecuritybase.modules.System.user.mapper.UserMapper;
import com.example.springsecuritybase.modules.System.user.model.dto.CreateUserDto;
import com.example.springsecuritybase.modules.System.user.model.dto.UpdateUserDto;
import com.example.springsecuritybase.modules.System.user.model.dto.UserSearchDto;
import com.example.springsecuritybase.modules.System.user.model.entities.User;
import com.example.springsecuritybase.modules.System.user.model.vo.UserVo;
import com.example.springsecuritybase.modules.System.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void createUser(CreateUserDto userDto) {
        String encode = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encode);

        User user = userConvert.CreateUserDtoToEntity(userDto);

        userMapper.insert(user);
    }

    @Override
    public void updateUser(UpdateUserDto userDto) {
        User user = userConvert.updateUserDtoToEntity(userDto);
        userMapper.updateById(user);
    }

    @Override
    public UserVo getOneById(Long id) {
        User user = userMapper.selectById(id);
        UserVo userVo = userConvert.entityToUserVo(user);
        return userVo;
    }


    @Override
    public Page<UserVo> selectPage(UserSearchDto searchDto) {
        Page<UserVo> page = new Page<>(searchDto.getPageNum(), searchDto.getPageSize());
        List<UserVo> userVoList = userMapper.getPage(searchDto,page);
        page.setRecords(userVoList);
        return page;
    }
}
