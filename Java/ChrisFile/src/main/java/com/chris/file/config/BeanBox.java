package com.chris.file.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;

/**
 * Created by Chris Chen
 * 2018/12/10
 * Explain:
 */

public class BeanBox {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
