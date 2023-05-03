package com.devstromo.thread_manipulation.consumer_producer;

import java.util.ArrayList;
import java.util.List;

class Processor {

    private final List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;
                    // we can call to notify - because the other thread will be notified
                    // only when it is in a waiting state
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for adding items...");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Removing: " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        var process = new Processor();
        var t1 = new Thread(() -> {
            try {
                process.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var t2 = new Thread(() -> {
            try {
                process.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
