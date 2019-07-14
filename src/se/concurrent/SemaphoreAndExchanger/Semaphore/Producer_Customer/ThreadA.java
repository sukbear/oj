package se.concurrent.SemaphoreAndExchanger.Semaphore.Producer_Customer;

/**
 * ..
 *
 * @author sukbear
 * @create 2018-12-12 15:26
 */
public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
