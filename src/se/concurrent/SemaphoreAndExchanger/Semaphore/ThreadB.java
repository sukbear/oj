package se.concurrent.SemaphoreAndExchanger.Semaphore;

/**
 * ..
 *
 * @author sukbear
 * @create 2018-12-12 9:42
 */
public class ThreadB extends Thread{
    private ServiceForAcquire service;

    public ThreadB(ServiceForAcquire service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
