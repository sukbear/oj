package se.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/***
 *@ClassName Main
 *@Description
 * @author sukbear
 * @create 2019-05-22 19:02
 */
public class ShareArgsModify {
    private static volatile AtomicInteger i=new AtomicInteger(0);
    public static void main(String[] args) {
        work1 a = new work1("a",i);
        work2 b = new work2("b",i);
        a.start();
        b.start();
    }
}
class work1 extends Thread{
    private  AtomicInteger i;

    public work1(String name, AtomicInteger i) {
        super(name);
        this.i = i;
    }

    @Override
    public void run() {
        while(i.intValue()<10){
            if(i.intValue()%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i.incrementAndGet());}
        }
    }
}
class work2 extends Thread{
    private  AtomicInteger i;

    public work2(String name, AtomicInteger i) {
        super(name);
        this.i = i;
    }

    @Override
    public void run() {
        while(i.intValue()<10){
            if(i.intValue()%2!=0){
                System.out.println(Thread.currentThread().getName()+": "+i.incrementAndGet());}
        }
    }
}