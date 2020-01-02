package com.chris.temp.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.JettyWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.embedded.UndertowWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 9:00
 * Use for:
 */
@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class BeanBox {
    //@Bean
    public WebServerFactoryCustomizer tomcatCustomizer(Environment environment,ServerProperties properties) {
        TomcatServletWebServerFactoryCustomizer customizer = new TomcatServletWebServerFactoryCustomizer(properties);
        properties.setPort(8022);
        return customizer;
    }

    //@Bean
    public WebServerFactoryCustomizer undertowCustomizer(Environment environment, ServerProperties properties) {
        UndertowWebServerFactoryCustomizer customizer = new UndertowWebServerFactoryCustomizer(environment, properties);
        properties.setPort(8023);
        return customizer;
    }

    @Bean
    public WebServerFactoryCustomizer jettyCustomizer(Environment environment, ServerProperties properties) {
        JettyWebServerFactoryCustomizer customizer = new JettyWebServerFactoryCustomizer(environment, properties);
        properties.setPort(8024);
        return customizer;
    }
}
