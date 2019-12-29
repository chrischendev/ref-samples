package com.chris.dfz.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 5:59
 * Use for: 自定义监听器
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        String msg = event.getMsg();
        System.out.println("监听器收到消息:" + msg);
    }
}
