package se.concurrent.SemaphoreAndExchanger.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 限制线程并发数量
 *
 * @author sukbear
 * @create 2018-12-12 9:35
 */
public class Service {
   /** permites代表同一时间内允许多少线程执行acquire()和release()*/
    private Semaphore semaphore = new Semaphore(3);
    public void testMethod(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+
            "  begin timer = "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+
                    "  end timer = "+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
