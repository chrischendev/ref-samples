package com.chris.dfz.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/27 18:44
 * Use for:
 */
public class ElTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ElConfig.class);

        test01(context);



        //context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context) {
        ElConfig elConfig = context.getBean(ElConfig.class);

        elConfig.show();
    }
}
