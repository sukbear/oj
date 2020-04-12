package se.classloadseq;

/***
 *@ClassName Father
 *@Description
 * @author sukbear
 * @create 2019-09-16 16:06
 */
public class Father extends Chao{
    private static String name = getName();
    private String address = getAdress();

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Father() {
        System.out.println("父类构造函数");
    }

    private String getAdress() {
        System.out.println("父类成员变量");
        return null;
    }

    private static String getName() {
        System.out.println("父类静态成员");
        return null;
    }
}
