package com.chris.dfz.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 7:01
 * Use for:
 */
public class AwareTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        Ent06 ent06 = context.getBean(Ent06.class);
        test02(ent06);
        context.close();
    }


    private static void test01(Ent06 ent06) throws IOException {
        //1. Bean名称
        System.out.println(ent06.getBeanName());
        //2. 资源加载器
        ResourceLoader resourceLoader = ent06.getResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:static/info.txt");
        System.out.println("读取文本文件内容：" + IOUtils.toString(resource.getInputStream()));
        //3. BeanFactory
        BeanFactory beanFactory = ent06.getBeanFactory();
        Ent07 ent07 = beanFactory.getBean(Ent07.class);
        ent07.say();

    }

    private static void test02(Ent06 ent06) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //类加载器
        ClassLoader classLoader = ent06.getClassLoader();
        Class<?> aClass = classLoader.loadClass(Ent07.class.getName());
        Ent07 ent07 = (Ent07) aClass.newInstance();
        ent07.say();
    }
}
