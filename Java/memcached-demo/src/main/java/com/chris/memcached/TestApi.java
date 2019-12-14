package com.chris.memcached;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/11/28 17:04
 * use for: 测试接口
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    @Autowired
    MemCachedClient memCachedClient;

    /**
     * 综合测试
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        // 放入缓存
        boolean flag = memCachedClient.set("username", "kalychen");
        System.out.println(flag);
        // 取出缓存
        Object value = memCachedClient.get("username");
        System.out.println(value);
        return String.valueOf(value);
    }

    /**
     * 写缓存
     *
     * @param k
     * @param v
     * @return
     */
    @RequestMapping("/put")
    public Boolean put(String k, String v) {
        // 放入缓存
        boolean flag = memCachedClient.set(k, v);
        return flag;
    }

    /**
     * 读缓存
     *
     * @param k
     * @return
     */
    @RequestMapping("/get")
    public String get(String k) {
        // 取出缓存
        Object value = memCachedClient.get(k);
        return String.valueOf(value);
    }
}
