package com.devstromo.thread_manipulation.executors.fixed;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {

    private final int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Work with id " + id + " is in work -thread id: " + Thread.currentThread()
          .threadId());
        var duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class FixedThreadExecutors {
    public static void main(String[] args) {
        // it is a single thread that will execute the task sequentially
        // so one after another
        var executor = Executors.newFixedThreadPool(5);

        for (var i = 0; i < 100; i++) {
            executor.execute(new Work(i + 1));
        }

        // we have to shut down the executor
    }
}
