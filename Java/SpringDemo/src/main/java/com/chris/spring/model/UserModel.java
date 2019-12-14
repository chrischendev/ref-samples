package com.chris.spring.model;

/**
 * create by: Chris Chan
 * create on: 2019/7/14 18:36
 * use for:
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

    public String getInfo() {
        return "我是一匹来自北方的狼";
    }

    public void show(String msg) {
        System.out.println(msg);
    }

    public void show() {
        show(getInfo());
    }
}
