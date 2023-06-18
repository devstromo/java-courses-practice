package com.devstromo.parallelization.sum;

class ParallelSum {

    private final ParallelWorker[] workers;
    private final int numOfThreads;

    public ParallelSum(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.workers = new ParallelWorker[numOfThreads];
    }

    // O(n) time algorithm
    public int sum(int[] nums) {
        // batch size
        int size = (int) Math.ceil(nums.length * 1.0 / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            workers[i] = new ParallelWorker(nums, i * size, (i + 1) * size);
            workers[i].start();
        }

        try {
            for (var worker : this.workers)
                worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var total = 0;
        for (var worker : this.workers)
            total += worker.getPartialSum();

        return total;
    }
}
