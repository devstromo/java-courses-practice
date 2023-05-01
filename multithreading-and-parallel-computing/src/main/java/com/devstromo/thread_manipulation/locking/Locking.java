package com.devstromo.thread_manipulation.locking;

public class Locking {

    public static int counter1 = 0;

    public static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1() {
        // at the same time != parallel - CPU time slicing
        synchronized (lock1) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() {
        var t1 = new Thread(() -> {
            for (var i = 0; i < 100000; i++) {
                increment1();
            }
        });

        var t2 = new Thread(() -> {
            for (var i = 0; i < 100000; i++) {
                increment2();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The counter1 is: " + counter1 + "\nThe counter2 is: " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
