package com.devstromo.thread_manipulation.executors.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {

    @Override
    public void run() {
        System.out.println("Updating and downloading stock related data from web...");
    }
}

class ScheduleThreadPool {
    public static void main(String[] args) {
        var executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
