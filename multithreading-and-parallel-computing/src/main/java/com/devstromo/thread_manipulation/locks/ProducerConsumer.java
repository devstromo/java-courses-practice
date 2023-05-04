package com.devstromo.thread_manipulation.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        // wait()
        condition.await();
        System.out.println("Again the Producer method...");
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        // we want to make sure that we start with the producer()
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method...");
        Thread.sleep(3000);
        // notify()
        condition.signal();
        lock.unlock();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        var worker = new Worker();
        var t1 = new Thread(() -> {
            try {
                worker.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var t2 = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
    }
}
