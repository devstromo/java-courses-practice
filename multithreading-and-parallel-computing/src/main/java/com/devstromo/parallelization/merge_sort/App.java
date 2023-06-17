package com.devstromo.parallelization.merge_sort;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime()
          .availableProcessors();

        var numbers1 = createArray(10000000);
        var numbers2 = new int[numbers1.length];

        System.arraycopy(numbers1, 0, numbers2, 0, numbers1.length);

        // PARALLEL MERGE SORT
        var startTime = System.currentTimeMillis();
        var parallelSort = new ParallelMergeSort(numbers1);
        parallelSort.parallelMergeSort(0, numbers1.length - 1, numOfThreads);
        var endTime = System.currentTimeMillis();

        System.out.printf("Time taken with parallel: %6d ms\n", endTime - startTime);
        //SEQUENTIAL MERGE SORT
        var startTime1 = System.currentTimeMillis();
        var sequential = new MergeSort(numbers2);
        sequential.sort();
        var endTime1 = System.currentTimeMillis();
        System.out.printf("Time taken with sequential: %6d ms\n", endTime1 - startTime1);
    }

    private static int[] createArray(int n) {
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }

        return a;
    }
}
