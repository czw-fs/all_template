package com.example.spring_source.demo.mybatisCache;

import com.example.spring_source.demo.mybatisCache.entity.User;
import com.example.spring_source.demo.mybatisCache.mapper.User2Mapper;
import com.example.spring_source.demo.mybatisCache.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatisCacheTest")
@RequiredArgsConstructor
public class MybatisCacheDemoController {


    //测试一级缓存
    // 1. 同意哥sqlSession生效
    private final UserMapper userMapper;

    @GetMapping("/fs")
    @Transactional //要有事务才会触发一级缓存
    public String test1() {

        User user1 = userMapper.selectById(1);
        System.out.println(user1);

        try {
            Thread.sleep(10000);//   睡眠10秒钟
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //直接修改库数据后发现还是返回和user1一样的数据
        User user2 = userMapper.selectById(1);
        System.out.println(user2);
        return "test";
    }

    //测试二级缓存
    //同一Mapper生效
    private final User2Mapper user2Mapper;

    @GetMapping("/fs2")
    public String test2() {

        User user1 = user2Mapper.selectById(1);
        System.out.println(user1);

        try {
            Thread.sleep(10000);//   睡眠10秒钟
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //直接修改库数据后发现还是返回和user1一样的数据
        User user2 = user2Mapper.selectById(1);
        System.out.println(user2);
        return "test";
    }
}
