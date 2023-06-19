package com.devstromo.fork_join_framework.simple1;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursionAction extends RecursiveAction {
    private final int simulatedWork;

    public SimpleRecursionAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        // if the task is too large then we split it and execute the task in parallel
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split the tasks... " + simulatedWork);
            var action1 = new SimpleRecursionAction(simulatedWork / 2);
            var action2 = new SimpleRecursionAction(simulatedWork / 2);

            action1.fork();
            action2.fork();

            invokeAll(action1, action2);
        } else {
            System.out.println("The task is rather small so sequential execution is fine...");
            System.out.println("The size of the task: " + simulatedWork);
        }
    }
}
