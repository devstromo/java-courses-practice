package com.devstromo.thread_manipulation.maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable {

    final ConcurrentMap<String, Integer> map;

    MapFirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("B", 12);
            Thread.sleep(1000);
            map.put("Z", 5);
            map.put("A", 25);
            Thread.sleep(2000);
            map.put("D", 19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MapSecondWorker implements Runnable {

    final ConcurrentMap<String, Integer> map;

    MapSecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(map.get("A"));
            Thread.sleep(2000);
            System.out.println(map.get("Z"));
            System.out.println(map.get("B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConcurrentMapExample {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<String, Integer>();
        var first = new MapFirstWorker(map);
        var second = new MapSecondWorker(map);
        new Thread(first).start();
        new Thread(second).start();
    }
}
