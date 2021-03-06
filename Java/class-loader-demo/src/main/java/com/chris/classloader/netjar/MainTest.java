package com.chris.classloader.netjar;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * create by: Chris Chan
 * create on: 2019/8/25 13:51
 * use for:
 */
public class MainTest {
    //已经打包好的jar包存放在我的阿里云服务器 /usr/share/nginx/html/upload/ 下
    private static String jarUrl="http://www.chrischen.com.cn/upload/class-loader-models-1.0.0.jar";
    public static void main(String[] args) throws Exception {
        test();
    }

    private static void test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        URL url=new URL(jarUrl);
        URLClassLoader urlClassLoader= (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class<URLClassLoader> urlClassLoaderClass = URLClassLoader.class;
        Method addURLMethod = urlClassLoaderClass.getDeclaredMethod("addURL", URL.class);

        addURLMethod.setAccessible(true);
        addURLMethod.invoke(urlClassLoader,url);
        addURLMethod.setAccessible(false);

        Class<?> aClass = urlClassLoader.loadClass("com.chris.loader.models.Stu");
        Object obj = aClass.newInstance();

        Field nameField = aClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"will chan");
        nameField.setAccessible(false);

        Field ageField = aClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj,42);
        ageField.setAccessible(false);

        System.out.println(new Gson().toJson(obj));
    }
}
