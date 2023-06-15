package com.devstromo.parallelization.merge_sort;

public class MergeSort {

    private int[] nums;

    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
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
            if (tempArray[i] < tempArray[j]) {
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

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
