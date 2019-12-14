package com.chris.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisDemo
 * com.chris.mybatis.config
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
@Configuration
@MapperScan(basePackages = {
        "com.chris.mybatis.dao"
})
public class AppConfig {
}
