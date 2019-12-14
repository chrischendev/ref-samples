package com.chris.concurrent;

public class SynchronizedTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Runnable runnable = new Runnable() {
            Object objec = new Object();

            @Override
            public void run() {
                synchronized (objec) {
                    try {
                        for (int i = 1; i <= 10; i++) {
                            System.out.println(Thread.currentThread().getName() + " : " + i);
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {

                    }
                }
            }
        };

        new Thread(runnable, "线程1").start();
        new Thread(runnable, "线程2").start();
    }
}


