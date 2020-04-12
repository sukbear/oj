package se.common.Singleton;

import se.common.Singleton.static_inner_class.Singleton;

import java.lang.reflect.Constructor;

/***
 *@ClassName BrokeSingletonStaticInner
 *@Description
 * @author sukbear
 * @create 2019-09-16 22:14
 */
public class BrokeSingletonStaticInner {
    public static void main(String[] args)throws Exception {
        //获取class对象
        Class cs =Singleton.class;
        //获取构造器
        Constructor constructor = cs.getDeclaredConstructor();
        //开启权限
        constructor.setAccessible(true);
        //反射获取
        Singleton singleton1 = (Singleton) constructor.newInstance();
        //正常获取
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton.equals(singleton1));

        //输出
  /*    se.common.Singleton.static_inner_class.Singleton@1540e19d
        se.common.Singleton.static_inner_class.Singleton@677327b6
        false*/
    }
}
