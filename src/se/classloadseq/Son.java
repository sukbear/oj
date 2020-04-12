package se.classloadseq;

/***
 *@ClassName Son
 *@Description
 * @author sukbear
 * @create 2019-09-16 16:12
 */
public class Son  extends Father{




    private static String name = get1Name();
    private String address = get1Adress();

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public Son() {
        System.out.println("子类构造函数");
    }

    private String get1Adress() {
        System.out.println("子类成员变量");
        return null;
    }

    private static String get1Name() {
        System.out.println("子类静态成员");
        return null;
    }
}
