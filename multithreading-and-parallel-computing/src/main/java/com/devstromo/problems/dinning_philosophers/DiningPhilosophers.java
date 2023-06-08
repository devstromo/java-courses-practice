package com.devstromo.problems.dinning_philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;

        Philosopher[] philosophers = null;
        Chopstick[] chopsticks = null;

        try {
            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
            chopsticks = new Chopstick[Constants.NUMBER_OF_PHILOSOPHERS];
            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
                chopsticks[i] = new Chopstick(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % Constants.NUMBER_OF_PHILOSOPHERS]);
                executorService.execute(philosophers[i]);
            }
            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
            executorService.shutdown();
            for (var philosopher : philosophers) {
                philosopher.setFull(true);
            }
        } finally {
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }
            for (var philosopher : philosophers) {
                System.out.println(philosopher + " eat #" + philosopher.getEatingCounter() + " times");
            }
        }

    }
}
