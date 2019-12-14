package com.chris.redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Type;
import java.util.Set;

/**
 * @author chrischan
 * create on 2019/6/27 10:42
 * use for:
 */
public class RedisTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        JedisPool jedisPool = new RedisManager().buildJedisPool();
        Jedis jedis = jedisPool.getResource();

        String tenantIdsJson = jedis.get("POWER_DATAV_CACHE_TENANTIDS");
        Type type = new TypeToken<Set<String>>() {
        }.getType();
        Set<String> tenantIds = gson.fromJson(tenantIdsJson, type);
        System.out.println(tenantIds.size());
        tenantIds.stream().forEach(tenantId -> System.out.println(tenantId));
    }
}
