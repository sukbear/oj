package se.dynamicproxy;

/***
 *@ClassName RealA
 *@Description
 * @author sukbear
 * @create 2019-09-07 10:59
 */
public class RealA implements SubjectA {
    @Override
    public void setUser(String name, String password) {
        System.out.println("name : "+name+" "+ "password: " + password);
    }
}
