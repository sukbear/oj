package se.concurrent.SemaphoreAndExchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author sukbear
 * @create 2018-12-12 15:44
 */
public class ThreadC extends Thread{
    private Exchanger<String> exchanger;

    public ThreadC(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            //System.out.println("在C线程中得到值=" + exchanger.exchange("I am C",5, TimeUnit.SECONDS));
            System.out.println("在C线程中得到值=" + exchanger.exchange("I am C"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
