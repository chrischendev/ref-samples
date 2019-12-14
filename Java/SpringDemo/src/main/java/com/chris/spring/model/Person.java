package com.chris.spring.model;

import org.springframework.stereotype.Component;

/**
 * create by: Chris Chan
 * create on: 2019/7/19 0:27
 * use for:
 */
@Component
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Yaoshihan";
        this.age = 38;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
