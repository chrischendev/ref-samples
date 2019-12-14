package com.chris.spring.config;

import com.chris.spring.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/7/19 0:15
 * use for:
 */
@Configuration
public class BeanBox1 {
    @Bean
    public UserModel userModel() {
        return new UserModel("SunFeifei", 39);
    }
}
