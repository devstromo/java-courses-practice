package com.devstromo.thread_manipulation.array;

import java.util.List;

class ReadTask implements Runnable {

    private final List<Integer> list;

    ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(list);
        }
    }

}
