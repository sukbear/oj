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
    static final int  threadCount = 550;

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(300);
        final CountDownLatch cdl = new CountDownLatch(threadCount);

        for(int i = 0;i<threadCount;i++){
            final int threadNum =i;
            execute.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    cdl.countDown();
                }
            });
        }
    }
    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
