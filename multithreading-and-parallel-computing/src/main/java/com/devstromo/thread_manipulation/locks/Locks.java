package com.devstromo.thread_manipulation.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    /**
     * ReentrantLock
     *
     * - it has the same behavior as the "synchronized approach"
     * - of course it has some additional features
     *    new ReentrantLock(boolean fairness)
     *
     *      If fairness parameter i set to be TRUE then the longest waiting thread will get the lock
     *      // if fairness is FALSE then there is no access order
     *      IMPORTANT: a good approach is to use try-catch-finally blocks when doing the critical section
     *      and call unlock() in the finally block
     */

    private static int counter = 0;

    private static final Lock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            increment();
        });
        var t2 = new Thread(() -> {
            increment();
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Value of the counter is: " + counter);
    }
}
