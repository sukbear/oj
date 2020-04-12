package se.common.Singleton.enum_class;

/***
 *@ClassName Main
 *@Description
 * @author sukbear
 * @create 2019-09-16 22:35
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //枚举不能被反射
        Class c = Singleton.class;
    }
}
