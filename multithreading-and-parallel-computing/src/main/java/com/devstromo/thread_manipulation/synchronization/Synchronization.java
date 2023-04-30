package com.devstromo.thread_manipulation.synchronization;

public class Synchronization {
    public static int counter = 0;

    public static int counter1 = 0;

    // we have to make sure this method is executed only by a single thread
    // at a given time
    public static synchronized void increment() {
        counter++;
    }

    // usually it is not a good practice to use synchronized keyword
    public static void increment1() {
        // class level locking
        // rule of thumb: we synchronize blocks that are 100% necessary
        synchronized (Synchronization.class) {
            counter1++;
        }
    }

    // usually it is not a good practice to use synchronized keyword
    public void increment2() {
        // object level locking
        synchronized (this) {
            counter1++;
        }
    }

    public static void process() {
        var t1 = new Thread(() -> {
            for (var i = 0; i < 100000; i++) {
                increment();
            }
        });

        var t2 = new Thread(() -> {
            for (var i = 0; i < 100000; i++) {
                increment();
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

        System.out.println("The counter is: " + counter);
    }

    public static void main(String[] args) {
        process();
    }
}
