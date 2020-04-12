package se.innerclass.non_static;

/***
 *@ClassName Anonymous_Outter
 *@Description
 * @author sukbear
 * @create 2019-09-15 17:06
 */
public class Anonymous_Outter {
/*    匿名内部类特殊局部内部类
    无构造方法体（无名字，用父类构造）。
    匿名内部类不能定义任何静态成员、方法和类。
    匿名内部类不能是public,protected,private,static。
    只能创建匿名内部类的一个实例。
    一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。
    因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。*/
public interface  c
{
    int i=10;
   void f();
}

    public static void main(String[] args) {
        Thread thread = new Thread( new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"isRunning");
            }
        });
        thread.run();
        thread.start();
        System.out.println(c.class);
    }

}
