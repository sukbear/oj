package se.innerclass.non_static;

/***
 *@ClassName Method_Outter
 *@Description
 * @author sukbear
 * @create 2019-09-15 17:05
 */
public class Method_Outter {
    private int noStaticInt = 1;
    private static int STATIC_INT = 2;

    public void fun() {
        System.out.println("外部类方法");
    }

    /**
     * 局部内部类，作用于方法
     * 在方法中定义的内部类称为局部内部类。
     * 与局部变量类似，局部内部类不能有访问说明符(public private protected)，方法
     * 因为它不是外围类的一部分，但是它可以访问当前代码块内的常量和此外围类所有的成员，
     * 和此外围类所有的成员。
     */
    void start() {
        class Function {
            int x;
            public Function(int x) {
                this.x = x;
            }

            private void fun(int y) {
                System.out.println("局部内部类的输出");
                System.out.println(STATIC_INT);
                System.out.println(noStaticInt);
               // System.out.println(params);
                System.out.println(y);
            }
        }
        Function function = new Function(3);
        System.out.println(function.x);
        function.fun(1);
    }

    public static void main(String[] args) {
        Method_Outter outter = new Method_Outter();
        outter.start();
    }
}
