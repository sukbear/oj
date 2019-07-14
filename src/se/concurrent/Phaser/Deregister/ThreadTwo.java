package se.concurrent.Phaser.Deregister;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author sukbear
 * @create 2018-12-12 19:11
 */
public class ThreadTwo implements Runnable {
    private Phaser phaser;

    public ThreadTwo(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("ThreadTwo");
        System.out.println(Thread.currentThread().getName()+"到达考试");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第1题...");
        doExercise1();
        System.out.println(Thread.currentThread().getName()+"做第1题完成...");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第2题...");
        doExercise2();
        System.out.println(Thread.currentThread().getName()+"做第2题完成...");
        phaser.arriveAndDeregister();
    }

    private void doExercise1() {
        long duration = 1000L;
        try {

            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise2() {
        long duration = 3L;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
