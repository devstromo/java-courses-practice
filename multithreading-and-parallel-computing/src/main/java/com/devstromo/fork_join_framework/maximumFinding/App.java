package com.devstromo.fork_join_framework.maximumFinding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static int THREASHOLD = 0;

    public static void main(String[] args) {
        var nums = initializeNums(300000000);
        THREASHOLD = nums.length / Runtime.getRuntime()
          .availableProcessors();

        var normalMaxFind = new SequentialMaxFinding();
        var start = System.currentTimeMillis();
        System.out.println("Max: " + normalMaxFind.max(nums));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();

        try (var forkJoinPool = new ForkJoinPool(Runtime.getRuntime()
          .availableProcessors())) {
            var findTask = new ParallelMaxTask(nums, 0, nums.length);
            start = System.currentTimeMillis();
            System.out.println("Max: " + forkJoinPool.invoke(findTask));
            System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
        }
    }

    private static long[] initializeNums(int n) {
        var random = new Random();
        var nums = new long[n];
        for (var i = 0; i < n; ++i)
            nums[i] = random.nextInt(1000);
        return nums;
    }
}
