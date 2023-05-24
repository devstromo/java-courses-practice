package com.devstromo.thread_manipulation.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * This is an unbounded BlockingQueue of objects that implement the Delayed
 * interface
 *
 * - DelayQueue keeps the elements internally until a certain delay has expired
 *
 * - an object can only be taken from the queue when its delay has expired !!! -
 *
 * We cannot place null items in the queue - The queue is sorted so that the
 * object at the head has a delay that has expired for the longest time.
 *
 * If no delay has expired, then there is no head element and poll( ) will
 * return null
 *
 * size() return the count of both expired and unexpired items !!!
 *
 */

class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(String message, long duration) {
        this.message = message;
        this.duration = System.currentTimeMillis() + duration;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        // this is the method that can compare objects
        if (duration < ((DelayedWorker) other).getDuration()) {
            return -1;
        }
        if (duration > ((DelayedWorker) other).getDuration()) {
            return 1;
        }
        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DelayedWorker{" + "message='" + message + '\'' + '}';
    }
}

class DelayQueuesExample {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> delayedQueue = new DelayQueue<>();

        try {
            //these can be inserted by different threads
            delayedQueue.put(new DelayedWorker("This is the first message...", 2000));
            delayedQueue.put(new DelayedWorker("This is the second message...", 10000));
            delayedQueue.put(new DelayedWorker("This is the third message...", 4500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // we can get the messages
        while (!delayedQueue.isEmpty()) {
            try {
                System.out.println(delayedQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
