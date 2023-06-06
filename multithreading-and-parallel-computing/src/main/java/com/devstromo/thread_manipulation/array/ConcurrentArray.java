package com.devstromo.thread_manipulation.array;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArray {
    private final List<Integer> list;

    public ConcurrentArray() {
        this.list = new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public void simulate() {
        var t1 = new Thread(new WriteTask(list));
        var t2 = new Thread(new WriteTask(list));
        var t3 = new Thread(new WriteTask(list));
        var t4 = new Thread(new ReadTask(list));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
