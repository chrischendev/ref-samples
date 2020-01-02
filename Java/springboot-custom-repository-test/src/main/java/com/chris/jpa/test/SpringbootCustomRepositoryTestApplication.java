package com.chris.jpa.test;

import com.chris.jpa.custom.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.chris.jpa.custom", "com.chris.jpa.test"}, repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class SpringbootCustomRepositoryTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCustomRepositoryTestApplication.class, args);
    }

}
