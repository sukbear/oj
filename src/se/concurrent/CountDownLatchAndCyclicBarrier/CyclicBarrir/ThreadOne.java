package se.concurrent.CountDownLatchAndCyclicBarrier.CyclicBarrir;

import java.util.concurrent.CyclicBarrier;

/**
 * @author sukbear
 * @create 2018-12-12 17:06
 */
public class ThreadOne extends Thread {
    private CyclicBarrier cb;

    public ThreadOne(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +" begin "+System.currentTimeMillis()+"等待凑齐2个");
            cb.await();
            System.out.println(Thread.currentThread().getName() +" end "+System.currentTimeMillis()+"已经凑齐2个");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
