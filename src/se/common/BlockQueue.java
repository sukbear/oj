package se.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *@ClassName BlockQueue
 *@Description
 * @author sukbear
 * @create 2019-06-03 16:25
 */
public class BlockQueue<T> {
    private List<T> container = new ArrayList<>();
    private int count;
    private  int capacity;
    private Lock lock = new ReentrantLock();
    private Condition EMPTY = lock.newCondition();
    private Condition FULL = lock.newCondition();

    public BlockQueue( int capacity){
        this.capacity = capacity;
    }

    public void add(T t) throws InterruptedException {
        if (t == null) {
            throw new NullPointerException();
        }
        lock.lockInterruptibly();
        try {
            try{
                while(count==capacity){
                    FULL.await();
                }
            }catch (InterruptedException e){
                FULL.signal();
                throw e;
            }
            container.add(t);
            System.out.println(t);
            ++count;
            EMPTY.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            try {
                while (count == 0) {
                    EMPTY.await();
                }
            } catch (InterruptedException e) {
                EMPTY.signal();
                throw e;
            }
            --count;
            T t = container.remove(0);
            System.out.println(t.toString());
            FULL.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        BlockQueue<Double> blockQueue = new BlockQueue<>(5);

        new Thread(()->{
            try {
                while(true){
                blockQueue.add(Math.random()*10);
                Thread.sleep((long)(Math.random()*1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

       new Thread(()->{
            try {
                while(true){
                    blockQueue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
