package se.concurrent.Phaser.Deregister;

import se.concurrent.Phaser.TestPhaser;

/**
 * @author sukbear
 * @create 2018-12-12 19:19
 */
public class Main {
    public static void main(String[] args) {
        TestPhaser phaser = new TestPhaser();
        System.out.println();
        Thread one = new Thread(new ThreadOne(phaser), "Student-one");
        Thread two = new Thread(new ThreadTwo(phaser), "Student-two");
        Thread three = new Thread(new ThreadThree(phaser), "Student-three");
        phaser.bulkRegister(3);

        one.start();
        two.start();
        three.start();
        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}
