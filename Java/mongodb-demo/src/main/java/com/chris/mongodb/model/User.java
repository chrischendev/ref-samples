package com.chris.mongodb.model;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 11:50
 * Use for:
 */
public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static User create(String name, int age) {
        return new User(name, age);
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
