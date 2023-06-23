package com.devstromo.fork_join_framework.maximumFinding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxTask extends RecursiveTask<Long> {

    private final long[] nums;
    private final int lowIndex;
    private final int highIndex;

    public ParallelMaxTask(long[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Long compute() {
        // if the array is small - then use sequential approach
        if (highIndex - lowIndex < 1000) {
            return sequentialMaxFinding();
        }
        // we have to use parallelization
        var middleIndex = (highIndex + lowIndex) / 2;

        var task1 = new ParallelMaxTask(nums, lowIndex, middleIndex);
        var task2 = new ParallelMaxTask(nums, middleIndex + 1, highIndex);
        invokeAll(task1, task2);
        return Math.max(task1.join(), task2.join());
    }

    private Long sequentialMaxFinding() {
        var max = nums[lowIndex];
        for (var i = lowIndex + 1; i < highIndex; i++)
            if (nums[i] > max)
                max = nums[i];
        return max;
    }
}
