package se.concurrent.ExecutorService.InvokeAnyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-13 14:08
 */
public class Main {
    public static void main(String[] args) {
        Callable<Integer> c1 = new Callable() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("一号");
                return 1;
            }
        };

        Callable<Integer> c2 = new Callable() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("二号");
                return 2;
            }
        };

        Callable<Integer> c3 = new Callable() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("三号");
                return 2;
            }
        };
        List<Callable<Integer>> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        ExecutorService service = new ThreadPoolExecutor(2, 2, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());
        service.submit(c3);
        try {
            Integer a = service.invokeAny(list, 2, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

