package com.example.springsecuritybase.modules.System.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.model.dto.UserDto;
import com.example.springsecuritybase.modules.System.model.entities.User;

public interface UserService extends IService<User> {
    User selectUserByUsername(String username);

    void createUser(UserDto userDto);
}
