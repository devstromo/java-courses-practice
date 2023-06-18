package com.devstromo.parallelization.sum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SumUnitTest {

    SequentialSum sequentialSum = new SequentialSum();

    @Test
    void testSequentialSum() {
        int[] nums = { 1, 2, 3, 4, 5 };
        assertEquals(15, sequentialSum.sum(nums));
    }

    @Test
    void testParallelSum() {
        var numsOfProcessors = Runtime.getRuntime()
          .availableProcessors();
        ParallelSum parallelSum = new ParallelSum(numsOfProcessors);
        int[] nums = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        assertEquals(75, parallelSum.sum(nums));
    }

    @Test
    void testSumCompare() {
        var numsOfProcessors = Runtime.getRuntime()
          .availableProcessors();
        ParallelSum parallelSum = new ParallelSum(numsOfProcessors);
        var random = new Random();
        int[] nums = new int[1000_000_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        var start = System.currentTimeMillis();
        System.out.println("Sum: " + sequentialSum.sum(nums));

        System.out.println("Time: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("Sum: " + parallelSum.sum(nums));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}