package se.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/***
 *@ClassName Reflect_
 *@Description
 * @author sukbear
 * @create 2019-09-17 12:39
 */
public class Reflect_ {
    /**
     * 在运行时判断任意一个对象所属的类；
     * 在运行时构造任意一个类的对象；
     * 在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）；
     * 在运行时调用任意一个对象的方法
     */
    public static void main(String[] args) throws Exception {
        //获取class
        Class s = methodClass.class;
        //获取实列
        Object o = s.newInstance();
        //获取指定方法
        Method method = s.getMethod("add", int.class, int.class);
        //执行方法
        Object res = method.invoke(o, 2, 2);
        System.out.println(res);
        //获取自身所有所有方法
        Method[] methods = s.getDeclaredMethods();
        for (Method md : methods) {
            //执行私有方法
            md.setAccessible(true);
            if (!"get".equals(md.getName().substring(0,3))) {
                System.out.println(md.invoke(o, 2, 3));
            }else{
                System.out.println(md.invoke(o));
            }
        }
        Field[] fields = s.getDeclaredFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
    }
}

class methodClass {
    public final int fuck = 100;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    private int mul(int a, int b) {
        return a * b;
    }

    private int getFuck() {
        return fuck;
    }
}