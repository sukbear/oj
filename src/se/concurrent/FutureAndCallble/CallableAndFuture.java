package se.concurrent.FutureAndCallble;



import java.util.concurrent.*;

/**
 * @author sukbear
 * @create 2018-12-13 9:57
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(1,2,3,TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());
        MyCallable callable = new MyCallable();
        Future<Integer> future = executor.submit(callable);
        Future futur = executor.submit(()-> System.out.println("fuck"));

        try {
            System.out.println(futur.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("============");

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
   static class MyCallable implements Callable {
        @Override
        public Integer call() throws Exception{

                System.out.println("正在计算");
                TimeUnit.SECONDS.sleep(2);
                int sum = 0;
                for(int i = 0;i <100;i++){
                    sum+=i;
                }
                return sum;
            }
        }
    }
