package common.Singleton.lazy;

/***
 *@ClassName Singleton1
 *@Description
 * @author sukbear
 * @create 2019-03-04 22:25
 *
 *
 * 同步方法下的懒汉 - 可用，不推荐
 * 优点：线程安全，可确保正常使用下（不考虑通过反射调用私有构造方法）只有一个实例
 * 缺点：每次获取实例都需要申请锁，开销大，效率低
 *
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }
    public static synchronized  Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
