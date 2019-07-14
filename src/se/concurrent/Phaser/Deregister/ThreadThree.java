package se.concurrent.Phaser.Deregister;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author sukbear
 * @create 2018-12-12 19:18
 */
public class ThreadThree implements Runnable{
    private Phaser phaser;

    public ThreadThree(Phaser phaser) {
        this.phaser = phaser;
    }
    @Override
    public void run() {
        System.out.println("ThreadThree");
        System.out.println(Thread.currentThread().getName()+"到达考试");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName()+"做第1题...");
        doExercise1();
        System.out.println(Thread.currentThread().getName()+"做第1题完成...");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第2题...");
        doExercise2();
        System.out.println(Thread.currentThread().getName()+"做第2题完成...");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第3题...");
        doExercise3();
        System.out.println(Thread.currentThread().getName()+"做第3题完成...");
        phaser.arriveAndAwaitAdvance();
    }

    private void doExercise1() {
        long duration = 2L;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise2() {
        long duration = 2L;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void doExercise3() {
        long duration = 2L;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
