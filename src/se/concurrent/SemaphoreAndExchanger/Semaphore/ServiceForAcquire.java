package se.concurrent.SemaphoreAndExchanger.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * ..
 *
 * @author sukbear
 * @create 2018-12-12 10:04
 */

/**
 * permits是许可的意思，acquire(permits)是调用一次此方法，就使用permits个许可
 */
public class ServiceForAcquire {
    private Semaphore semaphore = new Semaphore(1,false);

    public void testMethod() {

            semaphore.acquireUninterruptibly();
            System.out.println(Thread.currentThread().getName() +
                    "  begin timer = " + System.currentTimeMillis());
            for (int i = 0; i < Integer.MAX_VALUE /5; i++) {
                String s = new String();
                Math.random();
            }
            System.out.println(Thread.currentThread().getName() +
                    "  end timer = " + System.currentTimeMillis());
            semaphore.release();

    }
}
