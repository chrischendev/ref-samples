package com.chris.mm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages = {"com.chris.mm"})
@SpringBootApplication
public class MultiModuleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleWebApplication.class, args);
    }

}
