package com.chris.temp.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 8:19
 * Use for:
 */
//@Component
public class CustomServerContainer extends ServletWebServerFactoryCustomizer {


    public CustomServerContainer(ServerProperties serverProperties) {
        super(serverProperties);
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8021);
    }
}
