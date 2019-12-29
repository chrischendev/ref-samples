package com.chris.dfz.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 10:22
 * Use for:
 */
public class ConditionTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        test01(context);
        context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context) {
        context.getEnvironment().setActiveProfiles("dev");//改变条件
        context.register(ConditionConfig.class);
        context.refresh();

        IShowManager showManager = context.getBean(IShowManager.class);
        showManager.show();
    }
}
