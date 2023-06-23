package com.devstromo.fork_join_framework.maximumFinding;

public class SequentialMaxFinding {
    //linear search O(n)
    public long max(long[] nums) {
        long max = nums[0];
        for (var num : nums)
            if (num > max)
                max = num;
        return max;
    }
}
