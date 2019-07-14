package common.Singleton.lazy;

/***
 *@ClassName Singleton
 *@Description
 * @author sukbear
 * @create 2019-03-04 22:20
用volatile关键字的目的不是保证可见性（synchronized已经保证了可见性），
 而是为了保证顺序性。具体来说，INSTANCE = new Singleton()不是原子操作，
 实际上被拆分为了三步：
 1) 分配内存；
 2) 初始化对象；
 3) 将INSTANCE指向分配的对象内存地址。
 如果没有volatile，可能会发生指令重排，使得INSTANCE先指向内存地址，而对象尚未初始化，
 其它线程直接使用INSTANCE引用进行对象操作时出错。详细原理可参见《双重检查锁定与延迟初始化》*/

/**双重检查（Double Check）下的懒汉*/
public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {
    }
    public static Singleton getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
