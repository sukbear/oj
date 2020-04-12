package se.common.Singleton;

import java.util.concurrent.atomic.AtomicReference;

/***
 *@ClassName Singleton
 *@Description
 * @author sukbear
 * @create 2019-05-27 16:44
 */
public class Singleton {
    /**
     * 不使用synchronized和lock 锁实现线程安全单例
     * 可以使用饿汉，内部类、枚举
     * CAS
     */
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();
    //覆盖掉默认的公共方法
    private Singleton() {
    }

    public static Singleton getInstance() {
        for (; ; ) {
            Singleton singleton = INSTANCE.get();
            if (singleton == null) {
                singleton = new Singleton();
                INSTANCE.compareAndSet(null, singleton);
            }
            return singleton;
        }
    }
}
