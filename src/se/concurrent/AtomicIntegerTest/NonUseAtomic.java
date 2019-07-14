package se.concurrent.AtomicIntegerTest;

/**
 * @author sukbear
 * @create 2018-12-15 13:52
 */
public class NonUseAtomic {
    private volatile int count = 0;
    public synchronized  void increment(){
        count++;
    }
    public int getCount(){
        return this.count;
    }
}
