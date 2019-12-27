package com.chris.dfz.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/27 18:06
 * Use for:
 */
public class ScopeTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        testPrototype(context);



        context.close();
    }

    //prototype
    private static void testPrototype(AnnotationConfigApplicationContext context) {
        Ent02 ent01 = context.getBean(Ent02.class);
        Ent02 ent02 = context.getBean(Ent02.class);
        System.out.println(ent01.equals(ent02));
    }

    //单例Singleton
    private static void testSingeton(AnnotationConfigApplicationContext context) {
        Ent01 ent01 = context.getBean(Ent01.class);
        Ent01 ent02 = context.getBean(Ent01.class);
        System.out.println(ent01.equals(ent02));
    }

    private static void test01() {

    }
}
