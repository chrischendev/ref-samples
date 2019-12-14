package com.chris.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//尝试两个线程交替运行
public class ThreadTest {
    private static boolean state = false;
    private static Object object = new Object();
    private static ReentrantLock lock = new ReentrantLock(true);
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        Runnable runnable1 = new Runnable() {
            int i = 1;

            @Override
            public void run() {
                while (i <= 10) {
                    synchronized (object) {
                        if (!state) {
                            System.out.println(Thread.currentThread().getName() + " : " + (i++));
                            state = !state;
                        }
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            int i = 1;

            @Override
            public void run() {
                while (i <= 10) {
                    synchronized (object) {
                        if (state) {
                            System.out.println(Thread.currentThread().getName() + " : " + (i++));
                            state = !state;
                        }
                    }
                }
            }
        };
        new Thread(runnable1, "线程1").start();
        new Thread(runnable2, "线程2").start();

    }

    private static void test1() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        lock.lock();
                        if (state == false) {
                            System.out.println(Thread.currentThread().getName() + " : " + i);
                            state = true;
                            condition.await();
                        }
                        lock.unlock();
                        condition.signalAll();
                    }
                } catch (Exception e) {

                }

            }
        };
        Runnable runnable2 = new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        lock.lock();
                        if (state == true) {
                            System.out.println(Thread.currentThread().getName() + " : " + i);
                            state = false;
                            condition.await();
                        }
                        lock.unlock();
                        condition.signalAll();
                    }
                } catch (Exception e) {

                }

            }
        };
        new Thread(runnable1, "线程1").start();
        new Thread(runnable2, "线程2").start();
    }

    //通过阻塞队列来实现
    private static void test2() {
        ReentrantLock lock = new ReentrantLock(true);
        BlockingQueue queue = new ArrayBlockingQueue(1);
        new Thread(new writeRunnable(queue, lock), "线程1").start();
        new Thread(new readRunnable(queue, lock), "线程2").start();
    }
}

class readRunnable implements Runnable {
    private BlockingQueue queue;
    private ReentrantLock lock;

    public readRunnable(BlockingQueue queue, ReentrantLock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public readRunnable(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= 10; i++) {
                queue.take();
                lock.lock();
                System.out.println(name + " : " + i + " T: " + System.currentTimeMillis());
                lock.unlock();
                //Thread.sleep(5);
            }
        } catch (Exception e) {

        }
    }
}

class writeRunnable implements Runnable {
    private BlockingQueue queue;
    private ReentrantLock lock;

    public writeRunnable(BlockingQueue queue, ReentrantLock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public writeRunnable(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= 10; i++) {
                queue.put(i);
                lock.lock();
                System.out.println(name + " : " + i + " T: " + System.currentTimeMillis());
                lock.unlock();
                //Thread.sleep(5);
            }
        } catch (Exception e) {

        }
    }
}