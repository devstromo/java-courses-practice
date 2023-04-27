package com.devstromo.thread_manipulation.runnable;

public class ThreadManipulation {

    public static void main(String[] args) {
        // IT'S NOT PARALLEL EXECUTION
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        Thread t3 = new Runner3();
        Thread t4 = new Runner4();
        Thread t5 = new Thread(() -> {
            for (var i = 0; i < 10; i++) {
                System.out.println("Runner5: " + i);
            }
        });
        Thread t6 = new Thread(() -> {
            for (var i = 0; i < 10; i++) {
                System.out.println("Runner6: " + i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}

class Runner1 implements Runnable {

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner3 extends Thread {
    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner3: " + i);
        }
    }
}

class Runner4 extends Thread {

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner4: " + i);
        }
    }
}
