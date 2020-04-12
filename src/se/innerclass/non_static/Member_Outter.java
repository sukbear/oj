package se.innerclass.non_static;

import java.util.Arrays;
import java.util.List;

/***
 *@ClassName Member_Outter
 *@Description
 * @author sukbear
 * @create 2019-09-15 17:05
 */
public  class Member_Outter {
    /***成员内部类可以访问外部全部成员,但自己不能有静态成员*/
    private static List<String> list = Arrays.asList(new String[]{"dfd", "dsfdf"});
    private static int[] a = new int[2];
    int z = 2;
    public void fun() {
        System.out.println("外部方法");
    }

     protected class Inner {
        int z=5;
        static final int i = 1;
        String get(int position) {
            return list.get(position);
        }
        int f(int x){
            a[0]=1;
            //return x+a[0]+z;默认重名时访问自己的
            return x+a[0]+Member_Outter.this.z;
        }
    }
}
