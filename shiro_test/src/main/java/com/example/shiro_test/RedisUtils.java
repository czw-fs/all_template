package com.example.shiro_test;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisUtils<T> {

    private final RedisTemplate<String, T> redisTemplate;

    /**
     * 设置key和value
     */
    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
