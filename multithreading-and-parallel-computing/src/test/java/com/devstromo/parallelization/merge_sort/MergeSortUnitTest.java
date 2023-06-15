package com.devstromo.parallelization.merge_sort;

import org.junit.jupiter.api.Test;

class MergeSortUnitTest {

    @Test
    void testMergeSortSequential() {
        int[] nums = { 5, -1, 0, 7, 2, 3, 2, 1, 0, 1, 2 };
        var sort = new MergeSort(nums);
        sort.sort();
        sort.showArray();
    }

}