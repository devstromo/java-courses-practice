package com.devstromo.thread_manipulation.join;

public class ThreadManipulation {

    public static void main(String[] args) {
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();

        t1.start();
        t2.start();

        //  we can wait for the thread to finish: join()

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished with threads...");
    }
}

class Runner1 extends Thread {
    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 extends Thread {

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2: " + i);
        }
    }
}
