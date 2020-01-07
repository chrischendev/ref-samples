package com.chris.vertx.model;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 6:39
 * Use for:
 */
public class UserModel {
    private String name;
    private int age;

    public UserModel() {
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static UserModel create(String name, int age) {
        return new UserModel(name, age);
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
