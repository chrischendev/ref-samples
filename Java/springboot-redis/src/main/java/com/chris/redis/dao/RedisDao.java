package com.chris.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Create by Chris Chan
 * Create on 2020/1/4 11:14
 * Use for:
 */
@Repository
public class RedisDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    //下面这两个待研究
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperationsStr;
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOperations;

    public void setkv(String key, String value) {
        valueOperationsStr.set(key, value);
    }

    public String get(String key) {
        return valueOperationsStr.get(key);
    }
}
