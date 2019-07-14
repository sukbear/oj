package se.concurrent.SemaphoreAndExchanger.Semaphore;

/**
 * nothing
 *
 * @author sukbear
 * @create 2018-12-12 9:40
 */
public class ThreadA extends Thread{
    private ServiceForAcquire service;

    public ThreadA(ServiceForAcquire service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
