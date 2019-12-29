package com.chris.dfz.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 10:18
 * Use for:
 */
@Configuration
@ComponentScan("com.chris.dfz.conditional")
public class ConditionConfig {
    @Bean
    @Conditional(ConditionDev.class)
    public IShowManager showDev() {
        return new ShowDev();
    }

    @Bean
    @Conditional(ConditionProd.class)
    public IShowManager showProd() {
        return new ShowProd();
    }
}
