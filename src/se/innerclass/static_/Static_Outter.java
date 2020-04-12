package se.innerclass.static_;

/***
 *@ClassName Static_Outter
 *@Description
 * @author sukbear
 * @create 2019-09-15 17:05
 */
public class Static_Outter {
    private static int y = 3;
    private  int z = 3;
    protected static  class staticInner{
        //可以有
        // 静态成员
        static int i = 0;
        void f(){
            //非静态被引用报错
            //System.out.println(z+y);
            //同名可以
        }
    }

    public static void main(String[] args) {
        //静态内部类可以访问外部类的静态变量，而不可访问外部类的非静态变量；
        //静态内部类的创建不依赖于外部类，而非静态内部类必须依赖于外部类的创建而创建
        Static_Outter.staticInner inner =new Static_Outter.staticInner();
        inner.f();
    }
}
