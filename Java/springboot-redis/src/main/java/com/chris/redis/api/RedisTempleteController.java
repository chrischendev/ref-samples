package com.chris.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2020/1/4 10:35
 * Use for:
 */
@RestController
@RequestMapping("/temp")
public class RedisTempleteController {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/setkv")
    public String setkv(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "redis set KV success.";
    }

    @GetMapping("/get")
    public String get(String key) {
        return String.valueOf(stringRedisTemplate.opsForValue().get(key));
    }
}
