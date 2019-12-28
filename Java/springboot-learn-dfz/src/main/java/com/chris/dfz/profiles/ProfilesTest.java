package com.chris.dfz.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:19
 * Use for:
 */
public class ProfilesTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        test01(context, "prod");

        context.close();
    }

    private static void test01(AnnotationConfigApplicationContext context, String active) {
        context.getEnvironment().setActiveProfiles(active);
        context.register(ProfilesConfig.class);
        context.refresh();

        Ent03 ent03 = context.getBean(Ent03.class);

        ent03.say();
    }
}
