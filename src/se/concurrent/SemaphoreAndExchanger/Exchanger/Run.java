package se.concurrent.SemaphoreAndExchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author sukbear
 * @create 2018-12-12 15:37
 */
public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b= new ThreadB(exchanger);
        ThreadC c = new ThreadC(exchanger);
        ThreadD d = new ThreadD(exchanger);
        a.start();
        c.start();
        d.start();
        b.start();
    }
}
