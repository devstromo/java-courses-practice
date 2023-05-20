package com.devstromo.thread_manipulation.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

class Worker implements Runnable {

    private int id;
    private final CountDownLatch latch;

    public Worker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        doWork();
        latch.countDown();
    }

    private void doWork() {
        try {
            System.out.println("Thread with ID " + this.id + " start working");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Latch {
    ///**
    // * This is used to synchronize one or more tasks by forcing them to wait for the completion of a set of operations being performed by other tasks
    // *
    // * 		- You give an initial count to a CountDownLatch object, and any task that calls await()
    // * 				on that object will block until the count reaches zero
    // *
    // * 		- Other tasks may call countDown() on the object to reduce the count, presumably when a task finishes its job
    // * 		- A CountDownLatch is designed to be used in a one-shot fashion; the count cannot be reset !!!
    // * 				If you need a version that resets the count, you can use a CyclicBarrier instead
    // *
    // * 		- The tasks that call countDown() are not blocked when they make that call. Only the call to await() is blocked until the count reaches zero
    // *
    // * 		A typical use is to divide a problem into n independently solvable tasks and create a CountDownLatch with a value of n.
    // * 		When each task is finished it calls countDown() on the latch. Tasks waiting for the problem to be solved call await()
    // * 		on the latch to hold themselves back until it is completed
    // *
    // */
    public static void main(String[] args) {
        var latch = new CountDownLatch(5);
        var service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            service.execute(new Worker(i, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All task have been finished...");
        service.shutdown();
    }
}
