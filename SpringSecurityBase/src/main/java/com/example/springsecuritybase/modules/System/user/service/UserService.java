package com.example.springsecuritybase.modules.System.user.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.user.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.user.model.entities.User;

public interface UserService extends IService<User> {
    User selectUserByUsername(String username);

    void createUser(UserDto userDto);

    Page<UserDto> selectPage(UserDto userDto);

}
