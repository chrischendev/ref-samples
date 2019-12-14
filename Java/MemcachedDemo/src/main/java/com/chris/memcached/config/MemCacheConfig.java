package com.chris.memcached.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MemcachedDemo
 * com.chris.memcached
 * Created by Chris Chen
 * 2018/6/12
 * Explain: MemCache配置数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "memcache")
public class MemCacheConfig {
    private String[] servers;
    private boolean failover;
    private int initConn;
    private int minConn;
    private int maxConn;
    private int maintSleep;
    private boolean nagel;
    private int socketTO;
    private boolean aliveCheck;
}
