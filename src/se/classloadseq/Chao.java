package se.classloadseq;

/***
 *@ClassName Chao
 *@Description
 * @author sukbear
 * @create 2019-09-16 16:21
 */
public class Chao {
    private static String name = get2Name();
    private String address = get2Adress();

    static {
        System.out.println("超类静态代码块");
    }

    {
        System.out.println("超类代码块");
    }

    public Chao() {
        System.out.println("超类构造函数");
    }

    private String get2Adress() {
        System.out.println("超类成员变量");
        return null;
    }

    private static String get2Name() {
        System.out.println("超类静态成员");
        return null;
    }
}
