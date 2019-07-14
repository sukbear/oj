package se.concurrent.ScheduledExecutorService;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-15 10:49
 */
public class FixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("X " + System.currentTimeMillis());

        executorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("start - " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("end - " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);
        System.out.println("Y " + System.currentTimeMillis());

    }
}
