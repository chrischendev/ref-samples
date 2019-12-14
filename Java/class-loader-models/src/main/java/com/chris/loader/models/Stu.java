package com.chris.loader.models;

/**
 * create by: Chris Chan
 * create on: 2019/8/25 13:52
 * use for:
 */
public class Stu {
    private String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
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

    public void say() {
        System.out.println(name + " say hello~~~");
    }
}
