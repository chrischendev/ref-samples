package com.chris.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Runnable runnable = new Runnable() {
            ReentrantLock lock = new ReentrantLock(true);
            Condition condition=lock.newCondition();

            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        if (lock.hasWaiters(condition)) {
                            condition.await();
                            //Thread.sleep(1000);
                            condition.signal();
                        }
                        lock.unlock();
                    }
                }catch (Exception e){

                }
            }
        };

        new Thread(runnable,"线程1").start();
        new Thread(runnable,"线程2").start();
    }
}


