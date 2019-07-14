package se.concurrent.ThreadPoolExecutorAndExecutor.Excutor;

import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-12 20:15
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(1,2,3, TimeUnit.MINUTES,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.CallerRunsPolicy());
        pool.execute(()-> {System.out.println("fuck");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(()-> {System.out.println("fuc");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(()-> {System.out.println("fu");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(()-> {System.out.println("f");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(()-> {System.out.println("");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
