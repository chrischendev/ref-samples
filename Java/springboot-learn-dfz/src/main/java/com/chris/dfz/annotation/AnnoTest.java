package com.chris.dfz.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 11:56
 * Use for:
 */
public class AnnoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoConfig.class);
        test01(context);
        context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context) {
        Ent08 ent08 = context.getBean(Ent08.class);
        ent08.say();
    }
}
