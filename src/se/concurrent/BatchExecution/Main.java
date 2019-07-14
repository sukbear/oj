package se.concurrent.BatchExecution;

import java.util.concurrent.*;
/**
 *
 * 循环多个线程顺序执行 利用线程池顺序执行Single
 * 或者自定义线程池（保证先来先服务）
 *
 * new Sigle
 * */
/***
 *@ClassName relativeSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 20:43
 */
public class Main {
    static class A extends Thread {
        @Override
        public void run() {
            System.out.print("A");
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            System.out.print("B");
        }
    }


    static class C extends Thread {
        @Override
        public void run() {
            System.out.print("C");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy());
        A a = new A();
        B b = new B();
        C c = new C();
       for(int i =0;i<10;i++){
           pool.execute(a);
           pool.execute(b);
           pool.execute(c);
        }
        pool.shutdown();
    }
}
