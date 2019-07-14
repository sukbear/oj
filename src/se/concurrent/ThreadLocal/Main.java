package se.concurrent.ThreadLocal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *@ClassName algorithm.dp.Gift
 *@Description
 * @author sukbear
 * @create 2019-03-06 10:05
 */
public class Main {
  static   class TempThreadLocal extends ThreadLocal{
        AtomicInteger initialValue = new AtomicInteger(10);
        @Override
        protected Object initialValue() {
            return this.initialValue;
        }
    }
    public static void main(String[] args) {
        TempThreadLocal local = new TempThreadLocal();
        ExecutorService pool = new ThreadPoolExecutor(3,5,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.AbortPolicy());
        pool.execute(()->{
            System.out.println("t1:"+local.get());
           local.set(20);
            System.out.println("t1:"+local.get());
            local.remove();
            System.out.println("t1:"+local.get());
            System.out.println("====================");
            local.remove();
        });
        pool.execute(()->{
            System.out.println("t2:"+local.get());
            local.set(30);
            System.out.println("t2:"+local.get());
            local.remove();
        });
        pool.shutdown();
    }
}
