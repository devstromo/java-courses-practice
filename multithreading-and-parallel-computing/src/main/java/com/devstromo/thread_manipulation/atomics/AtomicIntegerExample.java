package com.devstromo.thread_manipulation.atomics;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerExample {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        //        var atomicInteger = new AtomicIntegerExample();
        //        new Thread(atomicInteger::increment, "thread1").start();
        //        new Thread(atomicInteger::increment, "thread2").start();

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

        System.out.println("Counter: " + counter.get());
    }

    public static void increment() {
        for (int i = 0; i < 10000; i++) {
            counter.getAndIncrement();
        }
    }
}
