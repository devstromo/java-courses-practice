package com.devstromo.thread_manipulation.array;

import java.util.List;
import java.util.Random;

public class WriteTask implements Runnable {
    private final List<Integer> list;
    private final Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.set(random.nextInt(list.size()), random.nextInt(10));
        }
    }

}
