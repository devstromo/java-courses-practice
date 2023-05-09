package com.devstromo.thread_manipulation.executors.single;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + id + " is in work -thread id: " + Thread.currentThread());
        var duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SingleThreadExecutors {

    public static void main(String[] args) {
        // it is a single thread that will execute the task sequentially
        // so one after another
        var executor = Executors.newSingleThreadExecutor();

        for (var i = 0; i < 5; i++) {
            executor.execute(new Task(i));
        }

        // we have to shut down the executor
    }
}
