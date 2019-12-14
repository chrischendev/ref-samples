package com.chris.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chrischan
 * create on 2019/6/27 10:40
 * use for:
 */
public class RedisManager {
    private String redisHost = "10.100.81.160";
    private int redisPort = 6379;
    private String redisAuth = "lrnJ5OPK";
    private int redisTimeOut = 5000;
    private int redisPoolMaxTotal = 30;
    private int redisPoolMaxIdle = 10;
    private int redisDatabase = 1;

    private JedisPool jedisPool;

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

    public String getRedisAuth() {
        return redisAuth;
    }

    public void setRedisAuth(String redisAuth) {
        this.redisAuth = redisAuth;
    }

    public int getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(int redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }

    public int getRedisPoolMaxTotal() {
        return redisPoolMaxTotal;
    }

    public void setRedisPoolMaxTotal(int redisPoolMaxTotal) {
        this.redisPoolMaxTotal = redisPoolMaxTotal;
    }

    public int getRedisPoolMaxIdle() {
        return redisPoolMaxIdle;
    }

    public void setRedisPoolMaxIdle(int redisPoolMaxIdle) {
        this.redisPoolMaxIdle = redisPoolMaxIdle;
    }

    public int getRedisDatabase() {
        return redisDatabase;
    }

    public void setRedisDatabase(int redisDatabase) {
        this.redisDatabase = redisDatabase;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public JedisPool buildJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisPoolMaxTotal);
        jedisPoolConfig.setMaxIdle(redisPoolMaxIdle);
        if (null == this.jedisPool) {
            this.jedisPool = new JedisPool(jedisPoolConfig, redisHost, redisPort, redisTimeOut, redisAuth, redisDatabase);
        }
        return this.jedisPool;
    }
}
