package com.chris.classloader.forname;

import java.lang.reflect.Field;

/**
 * create by: Chris Chan
 * create on: 2019/8/25 13:42
 * use for:
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //Class<?> aClass = Class.forName("com.chris.classloader.forname.User");
        Class<?> aClass = Class.forName("com.chris.classloader.forname.User",true,User.class.getClassLoader());
        Object obj = aClass.newInstance();
        Field nameField = aClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"chris chan");
        nameField.setAccessible(false);

        User user=(User)obj;
        System.out.println(user.getName());
    }
}
