package Thread;

import Crawl.Crawl;
import Frontier.Frontier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadControl {
    private int SemaphoreNumber;
    private Crawl crawler;

    public ThreadControl(int Number) {
        this.SemaphoreNumber = Number;
    }

    public void CreatThread() {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(SemaphoreNumber);

        for (int i = 0; i < Frontier.getSize(); i++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep((long) Math.random());
                        semp.acquire();
                        crawler = new Crawl(Thread.currentThread().getName());
                        crawler.Start(Frontier.nextUrl());
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}