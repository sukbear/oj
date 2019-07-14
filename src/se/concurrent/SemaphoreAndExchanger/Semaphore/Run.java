package se.concurrent.SemaphoreAndExchanger.Semaphore;

/**
 * DelayExecutor
 *
 * @author sukbear
 * @create 2018-12-12 9:44
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ServiceForAcquire service = new ServiceForAcquire();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(1000);
        b.interrupt();
        System.out.println("main中断了a");
    }
}
