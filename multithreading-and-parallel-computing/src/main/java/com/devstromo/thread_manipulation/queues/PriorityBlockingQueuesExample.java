package com.devstromo.thread_manipulation.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 *
 * 	- unbounded concurrent queue
 * 	- it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the COmparable interface
 * 			The comparable interface will determine what will the order in the queue
 *
 * 			The priority can be the same compare() == 0 case
 *
 *  - no null items !!!
 *
 *
 */

class FirstWorkerPB implements Runnable {
    private final BlockingQueue<String> queue;

    public FirstWorkerPB(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("B");
            queue.put("H");
            queue.put("F");
            Thread.sleep(2000);
            queue.put("A");
            Thread.sleep(1000);
            queue.put("Z");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SecondWorkerPB implements Runnable {
    private final BlockingQueue<String> queue;

    public SecondWorkerPB(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            Thread.sleep(2000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class PriorityBlockingQueuesExample {

    public static void main(String[] args) {
        var queue = new PriorityBlockingQueue<String>();
        var first = new FirstWorkerPB(queue);
        var second = new SecondWorkerPB(queue);

        new Thread(first).start();
        new Thread(second).start();
    }
}
