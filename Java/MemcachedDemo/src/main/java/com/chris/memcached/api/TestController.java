package com.chris.memcached.api;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MemcachedDemo
 * com.chris.memcached.api
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    MemCachedClient memCachedClient;

    @RequestMapping("/test")
    public String test() {
        // 放入缓存
        boolean flag = memCachedClient.set("username", "kalychen");

        // 取出缓存
        Object value = memCachedClient.get("username");
        System.out.println(value);
        return String.valueOf(value);
    }

    @RequestMapping("/put")
    public Boolean put(String key, String value) {
        // 放入缓存
        boolean flag = memCachedClient.set(key, value);
        return flag;
    }

    @RequestMapping("/get")
    public String get(String key) {
        // 取出缓存
        Object value = memCachedClient.get(key);
        System.out.println(value);
        return String.valueOf(value);
    }
}
