package com.chris.dfz.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 6:01
 * Use for: 自定义事件消息发布者
 */
@Component
public class MyEventPublisher {
    @Autowired
    ApplicationContext context;

    /**
     * 发布消息
     * @param msg
     */
    public void publish(String msg) {
        MyEvent myEvent = new MyEvent(this, msg);
        context.publishEvent(myEvent);
    }
}
