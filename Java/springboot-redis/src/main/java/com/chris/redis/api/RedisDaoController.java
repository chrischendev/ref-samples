package com.chris.redis.api;

import com.chris.redis.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2020/1/4 10:35
 * Use for:
 */
@RestController
@RequestMapping("/dao")
public class RedisDaoController {
    @Autowired
    RedisDao redisDao;

    @GetMapping("/setkv")
    public String setkv(String key, String value) {
        redisDao.setkv(key, value);
        return "redis set KV success.";
    }

    @GetMapping("/get")
    public String get(String key) {
        return String.valueOf(redisDao.get(key));
    }
}
