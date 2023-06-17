package com.devstromo.parallelization.merge_sort;

public class ParallelMergeSort {

    private final int[] nums;

    private final int[] tempArray;

    public ParallelMergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    private Thread createdThread(int low, int high, int numOfThreads) {
        return new Thread(() -> parallelMergeSort(low, high, numOfThreads / 2));
    }

    public void parallelMergeSort(int low, int high, int numOfThread) {
        if (numOfThread <= 1) {
            mergeSort(low, high);
            return;
        }
        int middleIndex = (low + high) / 2;
        var leftSorter = createdThread(low, middleIndex, numOfThread);
        var rightSorter = createdThread(middleIndex+1, high, numOfThread);

        leftSorter.start();
        rightSorter.start();
        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        merge(low, middleIndex, high);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }

        int middleIndex = (low + high) / 2;

        // we keep splitting the problem into smaller and smaller sub-problems
        //until a given array contains just one item
        mergeSort(low, middleIndex);
        mergeSort(middleIndex + 1, high);

        // combine sub-solutions
        merge(low, middleIndex, high);
    }

    private void merge(int low, int middle, int high) {
        // copy
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            } else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }

        // copy the items from the left sub-array(if there are any)
        while (i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }

        // copy the items from the right sub-array(if there are any)
        while (j <= high) {
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }
    }

    public void showArray() {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
