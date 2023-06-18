package com.devstromo.parallelization.sum;

class SequentialSum {
    // O(n) time algorithm
    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
