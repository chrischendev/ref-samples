package com.chris.spring.model;

/**
 * create by: Chris Chan
 * create on: 2019/7/19 0:13
 * use for:
 */
public class Stu {
    private String name;
    private int age;
    private double score;

    public Stu() {
    }

    public Stu(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
