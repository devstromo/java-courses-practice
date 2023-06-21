package com.devstromo.fork_join_framework.simpleTask;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {
        try (var pool = new ForkJoinPool()) {
            var task = new SimpleRecursiveTask(200);
            System.out.println(pool.invoke(task));
        }

        try (var pool = new ForkJoinPool()) {
            var task = new FibonacciTask(8);
            System.out.println(pool.invoke(task));
        }
    }
}
