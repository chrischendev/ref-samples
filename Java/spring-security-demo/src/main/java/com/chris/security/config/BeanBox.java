package com.chris.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 19:57
 * use for:
 */
@Configuration
public class BeanBox {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }
}
