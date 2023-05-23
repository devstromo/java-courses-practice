package com.devstromo.thread_manipulation.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * 	BlockingQueue -> an interface that represents a queue that is thread safe
 * 		Put items or take items from it ...
 *
 * 		For example: one thread putting items into the queue and another thread taking items from it
 * 			at the same time !!!
 * 				We can do it with producer-consumer pattern !!!
 *
 * 		put() putting items to the queue
 * 		take() taking items from the queue
 *
 */

class FirstWorker implements Runnable {
    private final BlockingQueue<Integer> queue;

    public FirstWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                queue.put(counter);
                System.out.println("Putting item into the queue..." + counter);
                counter++;
                Thread.sleep(101);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SecondWorker implements Runnable {
    private final BlockingQueue<Integer> queue;

    public SecondWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int counter = queue.take();
                System.out.println("Taking item from the queue..." + counter);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class BlockingQueuesExample {
    public static void main(String[] args) {
        var queue = new ArrayBlockingQueue<Integer>(10);
        var firstWorker = new FirstWorker(queue);
        var secondWorker = new SecondWorker(queue);
        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }

}
