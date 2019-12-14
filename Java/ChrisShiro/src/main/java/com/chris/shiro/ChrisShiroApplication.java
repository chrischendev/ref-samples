package com.chris.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.chris.shiro.model"})
//@ComponentScan(basePackages = {"com.chris.shiro"})
@EnableJpaRepositories(basePackages = {"com.chris.shiro.dao"})
public class ChrisShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChrisShiroApplication.class, args);
    }
}
