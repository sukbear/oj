package se.concurrent.ScheduledExecutorService;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-15 11:05
 */
public class ScheduleWithFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        executorService.scheduleWithFixedDelay(()->{
            try {
                System.out.println("b---"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("e---"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,5, TimeUnit.SECONDS);
    }
}
