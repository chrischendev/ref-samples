package com.chris.security.config.listener;

import com.chris.security.config.AppManager;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/9/27 11:37
 * use for:
 */
@Configuration
public class AppStartupListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        AppManager.init(applicationStartedEvent.getApplicationContext());
    }
}
