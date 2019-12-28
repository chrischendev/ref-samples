package com.chris.dfz.construct;

import com.chris.dfz.construct.beanmode.Ent04;
import com.chris.dfz.construct.jsr250.Ent05;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:32
 * Use for:
 */
public class BeanConstructTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConstructConfig.class);

        test01(context);


        context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context) {
        context.getBean(Ent04.class);
        context.getBean(Ent05.class);
    }
}
