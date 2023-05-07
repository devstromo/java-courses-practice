package com.devstromo.thread_manipulation.semaphores;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from the web...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Semaphores {

    /**
     * It is used to control access to a shared resource
     * that uses a counter variable
     * // semaphore maintains a set of permits
     * <p>
     * - acquire() ... if a permit is available the takes it
     * - release() ... adds a permit
     * <p>
     * Semaphore just keeps a count of the number of permits available
     * new Semaphore(int permits, boolean fair)!!!
     */

    public static void main(String[] args) {
        // create multiple threads -executors
        var service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(Downloader.INSTANCE::download);
        }
    }
}
