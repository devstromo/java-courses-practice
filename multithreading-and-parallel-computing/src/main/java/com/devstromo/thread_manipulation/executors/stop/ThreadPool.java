package com.devstromo.thread_manipulation.executors.stop;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {

    private final int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Work with id " + id + " is in work - thread id: " + Thread.currentThread()
          .threadId());
        var duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread()
              .interrupt();
        }
    }
}

class ThreadPool {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(new Work(i + 1));
        }
        // we prevent the executor to execute any further tasks
        executor.shutdown();

        // terminate actual (running) tasks
        try {
            if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
//                executor.shutdownNow();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
