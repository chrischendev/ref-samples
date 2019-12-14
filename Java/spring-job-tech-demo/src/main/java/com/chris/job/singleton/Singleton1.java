package com.chris.job.singleton;

/**
 * @author chrischan
 * create on 2019/7/4 17:40
 * use for: 单例模式练习 懒汉式 有并发问题
 * 时间换空间
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }
}
