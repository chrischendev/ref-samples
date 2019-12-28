package com.chris.dfz.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:16
 * Use for:
 */
@Configuration
@ComponentScan("com.chris.dfz.profiles")
public class ProfilesConfig {
    @Bean
    @Profile("dev")
    public Ent03 ent03_dev() {
        return new Ent03("Chris Chen");
    }

    @Bean
    @Profile("prod")
    public Ent03 ent03_prod() {
        return new Ent03("ChenFabao");
    }
}
