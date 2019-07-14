package se.concurrent.SemaphoreAndExchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author sukbear
 * @create 2018-12-12 15:47
 */
public class ThreadD extends Thread {
    private Exchanger<String> exchanger;

    public ThreadD(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在D线程中得到值=" + exchanger.exchange("I am D"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
