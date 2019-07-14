package se.concurrent.AtomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sukbear
 * @create 2018-12-15 13:56
 */
public class UseAtomic {
    private AtomicInteger count = new AtomicInteger(2);

    public void increment() {
        count.incrementAndGet();
    }

    public AtomicInteger getCount() {
        return this.count;
    }
}
