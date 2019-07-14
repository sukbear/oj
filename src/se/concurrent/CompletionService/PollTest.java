package se.concurrent.CompletionService;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-13 11:02
 */
public class PollTest {
    static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.AbortPolicy());
        CompletionService<String> cs = new ExecutorCompletionService<>(pool);
        cs.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("3s过后");
            return "ee";
        });
        CompletionService runCs = new ExecutorCompletionService(pool);
        runCs.submit(()->System.out.println("fuck"),new User("阿源").toString());
        pool.shutdown();
        try {
            System.out.println(cs.poll(4,TimeUnit.SECONDS));
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
