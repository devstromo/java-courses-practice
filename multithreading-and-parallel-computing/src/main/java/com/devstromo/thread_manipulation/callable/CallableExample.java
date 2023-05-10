package com.devstromo.thread_manipulation.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor implements Callable<String> {

    private final int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Id: " + id;
    }
}

class CallableExample {
    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(2);
        var list = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            var future = service.submit(new Processor(i + 1));
            list.add(future);
        }

        for (var future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
