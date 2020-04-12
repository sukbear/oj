package se.common.Singleton;

import java.lang.reflect.Constructor;

/***
 *@ClassName BrokeSingletonDouble
 *@Description
 * @author sukbear
 * @create 2019-09-16 22:28
 */
public class BrokeSingletonDouble {
    public static void main(String[] args) throws Exception {
        //获取class对象
        Class cs = se.common.Singleton.lazy.Singleton.class;
        //获取构造器
        Constructor constructor = cs.getDeclaredConstructor();
        //开启权限
        constructor.setAccessible(true);
        //先正常获取
        se.common.Singleton.lazy.Singleton singleton = se.common.Singleton.lazy.Singleton.getInstance();
        //再反射获取
        se.common.Singleton.lazy.Singleton singleton1 = (se.common.Singleton.lazy.Singleton) constructor.newInstance();
        //正常获取
        // se.common.Singleton.lazy.Singleton singleton = se.common.Singleton.lazy.Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton.equals(singleton1));
    }
}
