package com.chris.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 15:45
 * use for:
 */
@Configuration
// 用redis存储session
@EnableRedisHttpSession
public class AppConfig {
}
