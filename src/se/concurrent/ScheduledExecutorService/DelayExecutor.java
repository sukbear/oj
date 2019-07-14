package se.concurrent.ScheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-14 15:30
 */
public class DelayExecutor {
    public static void main(String[] args) {
        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(() -> {
            System.out.println("Call A begin" + Thread.currentThread().getName() + System.currentTimeMillis());
            System.out.println("Call A end" + Thread.currentThread().getName() + System.currentTimeMillis());
            return "returnA";
        });
        callableList.add(() -> {
            System.out.println("Call B begin" + Thread.currentThread().getName() + System.currentTimeMillis());
            System.out.println("Call B end" + Thread.currentThread().getName() + System.currentTimeMillis());
            return "returnB";
        });

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                return t;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());


        ScheduledFuture<String > futureA = executorService.schedule(callableList.get(0),4L,TimeUnit.SECONDS);
        ScheduledFuture<String > futureB = executorService.schedule(callableList.get(1),4L,TimeUnit.SECONDS);

        System.out.println("             x= "+System.currentTimeMillis());
        try {
            System.out.println("A = "+futureA.get());
            System.out.println("B = "+futureB.get());
            System.out.println("           Y = "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
