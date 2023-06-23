package com.devstromo.fork_join_framework.simpleTask;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    int num;

    public FibonacciTask(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num <= 1) {
            return num;
        } else {
            var n1 = new FibonacciTask(num - 1);
            var n2 = new FibonacciTask(num - 2);
            // avoid split several thread
            // n1.fork();
            n2.fork();
            // the actual thread executes fib1
            // and we create another thread(insert it into the pool)
            //associated with fib2
            return n1.compute() + n2.join();
        }
    }
}
