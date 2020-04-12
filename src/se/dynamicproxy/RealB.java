package se.dynamicproxy;

/***
 *@ClassName RealB
 *@Description
 * @author sukbear
 * @create 2019-09-07 11:00
 */
public class RealB implements SubjectB {
    @Override
    public void sayHello(String name) {
        System.out.println("this is serviceB");
    }
}
