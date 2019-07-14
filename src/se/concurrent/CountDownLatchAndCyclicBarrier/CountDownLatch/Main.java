package se.concurrent.CountDownLatchAndCyclicBarrier.CountDownLatch;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-12 16:49
 */
public class Main {
    /**
     * 1、只有当count为0时，await之后的程序才够执行
     * 2、countDown必须写在finally中，防止发生异程常时，导致程序死锁。
     */
    static CountDownLatch cdl = new CountDownLatch(1);

    public static void main(String[] args) {
        ExecutorService execute = new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
        execute.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                cdl.countDown();
            }
        });

        execute.execute(() -> {
            try {
                cdl.await();
                Thread.sleep(800);
                System.out.println("B");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        execute.shutdown();
    }
}
