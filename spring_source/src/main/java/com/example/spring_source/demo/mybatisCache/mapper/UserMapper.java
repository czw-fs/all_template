package com.example.spring_source.demo.mybatisCache.mapper;

import com.example.spring_source.demo.mybatisCache.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectById(@Param("userId") Integer userId);
}
