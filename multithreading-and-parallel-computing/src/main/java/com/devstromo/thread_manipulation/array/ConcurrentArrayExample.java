package com.devstromo.thread_manipulation.array;

class ConcurrentArrayExample {
    // CopyOnWriteArrays
    public static void main(String[] args) {
        var concurrentArray = new ConcurrentArray();
        concurrentArray.simulate();
    }
}
