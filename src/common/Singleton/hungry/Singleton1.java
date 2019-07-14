package common.Singleton.hungry;

/***
 *@ClassName Singleton1
 *@Description
 * @author sukbear
 * @create 2019-03-04 22:35
 *
 *
 * 静态内部类
 */
public class Singleton1 {
    public static Singleton1 getInstance(){
        return inner.instance;
    }
    private Singleton1() {
    }
    private  static class inner{
        private final static Singleton1 instance = new Singleton1();
    }
}
