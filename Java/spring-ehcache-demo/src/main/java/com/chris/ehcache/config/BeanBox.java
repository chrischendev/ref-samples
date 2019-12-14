package com.chris.ehcache.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 16:09
 * use for:
 */
@Configuration
public class BeanBox {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
