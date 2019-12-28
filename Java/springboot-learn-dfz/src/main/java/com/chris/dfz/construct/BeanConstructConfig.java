package com.chris.dfz.construct;

import com.chris.dfz.construct.beanmode.Ent04;
import com.chris.dfz.construct.jsr250.Ent05;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:32
 * Use for:
 */
@Configuration
@ComponentScan("com.chris.dfz.construct")
public class BeanConstructConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Ent04 ent04() {
        return new Ent04();
    }

    @Bean
    public Ent05 ent05() {
        return new Ent05();
    }

}
