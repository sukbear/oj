package se.concurrent.CountDownLatchAndCyclicBarrier.CyclicBarrir;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @author sukbear
 * @create 2018-12-12 17:11
 */
public class Run {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.println("全来了"));
        List<ThreadOne> list = new ArrayList<>(3);
        list.add(new ThreadOne(cb));
        list.add(new ThreadOne(cb));
        list.add(new ThreadOne(cb));
        list.add(new ThreadOne(cb));
        list.add(new ThreadOne(cb));
       list.forEach((a) ->{a.start();
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
    }
}
