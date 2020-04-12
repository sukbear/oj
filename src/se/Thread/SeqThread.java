package se.Thread;

import java.util.concurrent.Semaphore;

/***
 *@ClassName SeqThread
 *@Description
 * @author sukbear
 * @create 2019-10-08 15:49
 */
public class SeqThread {
    /**
     * Join（）作用：让主线程等待子线程运行结束后才能继续运行。
     * 利用并发包里的Excutors的newSingleThreadExecutor产生一个单线程的线程池
     */
   static Semaphore sA = new Semaphore(1);
    static Semaphore sB = new Semaphore(0);
    static  Semaphore sC = new Semaphore(0);
    public static void main(String[] args) throws Exception {
        A a = new A();
            B b = new B();
            C c = new C();
           /*   a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();*/
    }

    static class A extends Thread {
        @Override
        public void run() {
            try {
                sA.acquire();
                System.out.println("A");
                sB.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            System.out.println("B");
        }
    }

    static class C extends Thread {
        @Override
        public void run() {
            System.out.println("C");
        }
    }
}