package com.chris.job.singleton;

/**
 * @author chrischan
 * create on 2019/7/4 17:40
 * use for: 单例模式练习 饿汉模式
 * 空间换时间
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
