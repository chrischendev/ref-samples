package com.chris.dfz.config;

import com.chris.dfz.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 6:44
 * Use for: 上下文加载成功后
 */
@Configuration
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    EventService eventService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();

        //测试事件监听和消息发布
        eventService.test01();
    }
}
