package Thread;

import Crawl.Crawl;
import Frontier.Frontier;
import Parser.DataProcess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadControl {
    private int SemaphoreNumber;
    private Crawl crawler;
    private ExecutorService exec;

    public ThreadControl(int Number) {
        this.SemaphoreNumber = Number;
        this.exec = Executors.newCachedThreadPool();
    }

    public void Start() {
        final Semaphore semp = new Semaphore(SemaphoreNumber);

        for (int i = 0; i < Frontier.getSize(); i++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
                        /*
                         * select task
                         */
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

        try {
            if (exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                /*
                 * check All data is already download
                 * if false, then createProcess
                 */
            }
        } catch (InterruptedException e) {
        }
    }

    private void createCrawl() {
        crawler = new Crawl(Frontier.nextUrl(), Thread.currentThread().getName());
        crawler.Start();
    }

    private void createProcess() {
        DataProcess.handling();
    }
}