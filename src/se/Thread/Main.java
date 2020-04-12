package se.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/***
 *@ClassName Main
 *@Description
 * @author sukbear
 * @create 2019-06-02 16:03
 */
public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        FutureTask<Boolean> a = new FutureTask<Boolean>(new TaskA());
        FutureTask<Boolean> b = new FutureTask<Boolean>(new TaskB());
        FutureTask<Boolean> c = new FutureTask<Boolean>(new TaskC());

        pool.submit(a);
        pool.submit(b);
        pool.submit(c);
        for (; ; ) {
            if (a.get() && b.get() && c.get()) {
                pool.submit(new TaskD());
                pool.submit(new TaskE());
                break;
            }
        }
        pool.shutdown();
    }
}
