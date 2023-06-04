package com.devstromo.thread_manipulation.exchanger;

import java.util.concurrent.Exchanger;

class FirstThread implements Runnable {
    private int counter;
    private final Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                counter++;
                System.out.println("FirstThread increment the counter: " + counter);
                counter = exchanger.exchange(counter);
                System.out.println("FirstThread get the counter: " + counter);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SecondThread implements Runnable {
    private int counter;
    private final Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                counter--;
                System.out.println("SecondThread decrement the counter: " + counter);
                counter = exchanger.exchange(counter);
                System.out.println("SecondThread get the counter: " + counter);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ExchangerExample {
    /**
     * With the help of Exchanger -> two threads can exchange objects
     *
     * exchange() -> exchanging objects is done via one of the two exchange()
     * methods
     *
     * 	For example: genetic algorithms, training neural networks
     *
     */

    public static void main(String[] args) {
        var exchanger = new Exchanger<Integer>();
        var t1 = new FirstThread(exchanger);
        var t2 = new SecondThread(exchanger);
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
