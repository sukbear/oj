package se.concurrent.CompletionService;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-13 10:24
 */
public class CompletionServiceTest {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(6), new ThreadPoolExecutor.CallerRunsPolicy());

        CompletionService<Integer> service = new ExecutorCompletionService<>(pool);

        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                System.out.println("fuck");
                TimeUnit.SECONDS.sleep(1);
                return 1;
            });
        }
        pool.shutdown();
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("线程"+(service.take().get()+i)+"任务结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
