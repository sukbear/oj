package se.concurrent.SemaphoreAndExchanger.Semaphore.Producer_Customer;

/**
 * @author sukbear
 * @create 2018-12-12 15:27
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
