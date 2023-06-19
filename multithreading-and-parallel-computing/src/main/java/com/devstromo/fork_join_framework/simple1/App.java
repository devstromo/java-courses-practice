package com.devstromo.fork_join_framework.simple1;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {
        int n = Runtime.getRuntime()
          .availableProcessors();
        var pool = new ForkJoinPool();
        var action = new SimpleRecursionAction(200);
        action.invoke();
    }
}
