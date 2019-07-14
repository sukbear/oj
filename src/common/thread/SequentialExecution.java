package common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *@ClassName SequentialExecution
 *@Description
 * @author sukbear
 * @create 2019-05-23 22:18
 */
public class SequentialExecution {
    /**
     * 让线程顺序执行
     * 1、利用join方法
     * 2、利用线程池的 newSingleThreadExecutor
     *
     * */
    static class A extends Thread {
        @Override
        public void run() {
            System.out.println("正在运行A");
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            System.out.println("正在运行B");
        }
    }

    static class C extends Thread {
        @Override
        public void run() {
            System.out.println("正在运行C");
        }
    }
    public static void joinMethod() throws InterruptedException {
        A a = new A();
        a.start();
        a.join();
        B b = new B();
        b.start();
        b.join();
        C c = new C();
        c.start();
        c.join();
        Thread.sleep(100L);
    }
    public static void poolMethod(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        A a = new A();
        B b = new B();
        C c = new C();
        pool.execute(a);
        pool.execute(b);
        pool.execute(c);
        pool.shutdown();
    }
    public static void main(String[] args) throws InterruptedException {
        joinMethod();
        poolMethod();
    }
}
