package se.common.Singleton.hungry;

/***
 *@ClassName Singleton
 *@Description
 * @author sukbear
 * @create 2019-03-04 22:32
 *
 * 优点：实现简单，无线程同步问题
 * 缺点：在类装载时完成实例化。若该实例一直未被使用，则会造成资源浪费
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance(){
        return instance;
    }
}
