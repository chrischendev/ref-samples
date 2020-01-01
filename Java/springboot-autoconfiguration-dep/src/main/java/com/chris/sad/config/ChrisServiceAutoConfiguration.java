package com.chris.sad.config;

import com.chris.assist.ChrisAutoConfigurationCondition;
import com.chris.sad.ChrisService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 2:13
 * Use for: 自定义自动配置
 */
@Configuration
@ConditionalOnClass(ChrisAutoConfigurationCondition.class)
public class ChrisServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(ChrisAutoConfigurationCondition.class)
    public ChrisService chrisService() {
        return new ChrisService();
    }
}
