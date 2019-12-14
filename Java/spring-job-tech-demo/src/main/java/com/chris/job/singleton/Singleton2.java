package com.chris.job.singleton;

/**
 * @author chrischan
 * create on 2019/7/4 17:40
 * use for: 单例模式练习 懒汉式 无并发问题 推荐使用
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        //双重检查
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
