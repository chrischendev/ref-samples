package com.chris.dfz.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 12:21
 * Use for: 测试类在src/test/java下
 */
@Configuration
public class TestConfig {
    @Bean
    @Profile("dev")
    public Ent09 ent09dev() {
        return new Ent09("开发环境");
    }

    @Bean
    @Profile("prod")
    public Ent09 ent09prod() {
        return new Ent09("生产环境");
    }
}
