package com.example.shiro_test.mapper;

import com.example.shiro_test.model.entities.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper{

    User selectByName(@Param("username") String username);

    User selectById(@Param("id") Long userId);
}
