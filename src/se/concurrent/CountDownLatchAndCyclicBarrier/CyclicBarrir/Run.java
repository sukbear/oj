package se.concurrent.CountDownLatchAndCyclicBarrier.CyclicBarrir;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sukbear
 * @create 2018-12-12 17:11
 */
public class Run {
    private static final int threadNum = 550;
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5,()-> System.out.println("线程到达优先执行"));

    public static void main(String[] args) throws InterruptedException{
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i =0;i<threadNum;i++){
            final int num = i;
            Thread.sleep(100);
            pool.execute(()-> {
                try {
                    test(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        CYCLIC_BARRIER.await();
        System.out.println("threadnum:" + threadnum + "is finish");
    }
}
