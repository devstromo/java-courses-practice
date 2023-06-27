package com.devstromo.streamApi;

import java.util.Arrays;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args) {
        var nums = new int[] { 1, 5, 3, -2, 9, 12 };
        Arrays.stream(nums)
          .forEach(System.out::println);
        System.out.println();
        IntStream.range(0, 10)
          .forEach(x -> System.out.println(x + " "));
        System.out.println();
        IntStream.range(0, 10)
          .filter(x -> x > 4)
          .forEach(x -> System.out.println(x + " "));
    }
}
