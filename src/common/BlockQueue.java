package common;

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
    private Lock lock = new ReentrantLock();
    private Condition NULL = lock.newCondition();
    private Condition FULL = lock.newCondition();

    public void add(T t) throws InterruptedException {
        if (t == null) {
            throw new NullPointerException();
        }
        lock.lockInterruptibly();
        try {
            container.add(t);
            ++count;
            NULL.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            try {
                while (count == 0) {
                    NULL.await();
                }
            } catch (InterruptedException e) {
                NULL.signal();
                throw e;
            }
            --count;
            T t = container.remove(0);
            FULL.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

}
