package com.chris.webflux;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.WebHandler;

/**
 * create by: Chris Chan
 * create on: 2019/12/4 11:30
 * use for:
 */
@Configuration
@ComponentScan
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
    @Bean
    public WebHandler webHandler(ApplicationContext context) {
        DispatcherHandler handler = new DispatcherHandler(context);
        return handler;
    }
}
