package se.concurrent.SemaphoreAndExchanger.Semaphore.Semaphore_Pool_List;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Semaphore创建字符串池 （若干个同时访问，同时只有一个可以取得数据，使用完在放回）
 *
 * @author sukbear
 * @create 2018-12-12 10:57
 */
public class ListPool {
    private int poolMaxSize = 3;
    private int semaphorePermites = 5;
    private List<String> list = new ArrayList<>();
    private Semaphore concurrencySemaphore = new Semaphore(semaphorePermites);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public ListPool() {
        for (int i = 0; i < poolMaxSize; i++) {
            list.add(" 高红颜 " + (i + 1));
        }
    }

    public String get(){
        String getString = null;
        try {
            concurrencySemaphore.acquire();
            lock.lock();
            while(list.size() ==0){
                condition.await();
            }
            getString = list.remove(0);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getString;
    }

    public void put(String str){
        lock.lock();
        list.add(str);
        condition.signalAll();
        lock.unlock();
        concurrencySemaphore.release();
    }
}
