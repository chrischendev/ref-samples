package com.chris.redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author chrischan
 * create on 2019/6/27 10:42
 * use for:
 */
public class RedisTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        //testWrite();
        testRead();
    }

    /**
     * 测试写入
     */
    private static void testWrite() {
        JedisPool jedisPool = new RedisManager().buildJedisPool();
        Jedis jedis = jedisPool.getResource();

        jedis.set("username", "chrischan");
    }

    /**
     * 测试读取
     */
    private static void testRead() {
        JedisPool jedisPool = new RedisManager().buildJedisPool();
        Jedis jedis = jedisPool.getResource();

        String username = jedis.get("username");
        System.out.println(username);
    }
}
