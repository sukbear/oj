package se.concurrent.SemaphoreAndExchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author sukbear
 * @create 2018-12-12 15:40
 */
public class ThreadB extends Thread{
    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在B线程中得到值=" + exchanger.exchange("I am B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
