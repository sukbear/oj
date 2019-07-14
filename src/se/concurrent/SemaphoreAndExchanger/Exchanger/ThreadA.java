package se.concurrent.SemaphoreAndExchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author sukbear
 * @create 2018-12-12 15:34
 */
public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在A线程中得到值=" + exchanger.exchange("I am A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
