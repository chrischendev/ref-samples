package com.chris.dfz.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 6:05
 * Use for:
 */
public class EventTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);
        test01(context);
        context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context) {
        MyEventPublisher myEventPublisher = context.getBean(MyEventPublisher.class);
        myEventPublisher.publish("我和我的祖国,一刻也不能分割。");
    }
}
