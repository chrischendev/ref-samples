package com.chris.spring;

import com.chris.spring.config.BeanBox;
import com.chris.spring.config.BeanBox1;
import com.chris.spring.model.Person;
import com.chris.spring.model.Stu;
import com.chris.spring.model.UserModel;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * create by: Chris Chan
 * create on: 2019/7/14 18:27
 * use for:
 */
public class MainTest {
    public static void main(String[] args) {
        testAnnotation1();
    }

    private static void testAnnotation1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.chris.spring");
        context.refresh();
        Person person = context.getBean(Person.class);
        //person.setName("KalyChan");
        System.out.println(person.getName());
    }

    private static void testAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanBox.class);
        context.register(BeanBox1.class);
        context.refresh();
        Stu stu = context.getBean(Stu.class);
        UserModel userModel = context.getBean(UserModel.class);
        System.out.println(stu.getName());
        System.out.println(userModel.getName());
    }

    private static void testXmlBeanFactory() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        UserModel userModel = (UserModel) beanFactory.getBean("userModel");
        userModel.show();
    }

    private static void testXmlBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserModel userModel = (UserModel) context.getBean("userModel");
        userModel.show();
    }
}
