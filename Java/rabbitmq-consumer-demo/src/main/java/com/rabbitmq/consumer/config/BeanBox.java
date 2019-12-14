package com.rabbitmq.consumer.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chris Chen
 * 2019/01/07
 * Explain:
 */
@Configuration
public class BeanBox {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
