package se.common.Singleton.static_inner_class;

/***
 *@ClassName Singleton
 *@Description
 * @author sukbear
 * @create 2019-03-04 22:38
 *
 * 无线程同步问题，实现了懒加载（Lazy Loading）。
 * 因为只有调用getInstance时才会装载内部类，才会创建实例。
 * 同时因为使用内部类时，先调用内部类的线程会获得类初始化锁，
 * 从而保证内部类的初始化（包括实例化它所引用的外部类对象）线程安全。
 */
public class Singleton {
    public static Singleton getInstance() {
        return InnerClass.instance;
    }
    //覆盖掉公共默认构造方法
    private Singleton() {
        /*if(InnerClass.instance!=null){
            throw new IllegalStateException();
        }*/
    }

    private static class InnerClass {
        private static final Singleton instance = new Singleton();
    }
}
