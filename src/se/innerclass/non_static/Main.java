package se.innerclass.non_static;

/***
 *@ClassName Main
 *@Description
 * @author sukbear
 * @create 2019-09-15 17:15
 */
public class Main {
    public static void main(String[] args) {
        /**成员内部类*/
        //声明
        Member_Outter m  = new Member_Outter();
        Member_Outter.Inner m_inner = m.new Inner();
        System.out.println(m_inner.f(2));
    }
}
