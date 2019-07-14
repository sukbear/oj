package se.concurrent.SemaphoreAndExchanger.Semaphore;

/**
 * 。。
 *
 * @author sukbear
 * @create 2018-12-12 9:43
 */
public class ThreadC extends Thread{
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
