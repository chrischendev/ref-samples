package com.chris.job.singleton;

/**
 * @author chrischan
 * create on 2019/7/4 17:43
 * use for: 单例模式测试
 */
public class SingletonTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test2() {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();

        System.out.println(instance1 == instance2);
    }

    private static void test1() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
