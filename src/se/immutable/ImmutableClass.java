package se.immutable;

import java.lang.reflect.Field;

/***
 *@ClassName ImmutableClass
 *@Description
 * @author sukbear
 * @create 2019-09-15 15:03
 */
public class ImmutableClass {
    /**
     * Java平台类库中包含许多不可变的类，
     * 其中有String(但是还是可以通过反射机制改变其值)、基本类型的包装类、BigInteger、BigDecimal。
     * <p>
     * 不可变类的真正唯一的缺点是，对于每个不同的值都需要一个单独的对象
     * 如何在Java中写出Immutable的类？要写出这样的类，需要遵循以下几个原则：
     * <p>
     * 1）immutable对象的状态在创建之后就不能发生改变，任何对它的改变都应该产生一个新的对象。
     * <p>
     * 2）Immutable类的所有的成员都应该是private final的。通过这种方式保证成员变量不可改变。但只做到这一步还不够，因为如果成员变量是对象，它保存的只是引用，有可能在外部改变其引用指向的值，所以第5点弥补这个不足
     * <p>
     * 3）对象必须被正确的创建，比如：对象引用在对象创建过程中不能泄露。4）只提供读取成员变量的get方法，不提供改变成员变量的set方法，避免通过其他接口改变成员变量的值，破坏不可变特性。
     * <p>
     * 5）类应该是final的，保证类不被继承，如果类可以被继承会破坏类的不可变性机制，只要继承类覆盖父类的方法并且继承类可以改变成员变量值，那么一旦子类以父类的形式出现时，不能保证当前类是否可变。
     * <p>
     * 6）如果类中包含mutable类对象，那么返回给客户端的时候，返回该对象的一个深拷贝，而不是该对象本身（该条可以归为第一条中的一个特例）
     *
     *
     * Java只有值传递：
     * Person p = new Person()
     * p所指向的那个存储单元中的内容是实体对象的地址，使得p也指向了该实体对象，所以才能改变对象内部的属性！
     *
     * 深拷贝和浅拷贝
     * 默认是浅拷贝（对于只有不可变类 就可以了）拷贝的是地址（指向同一对象）
     *  深拷贝（不同对象）1、序列化 2、覆写Cloneable接口方法
     *
     *
     */
    public static void main(String[] args)throws Exception {
        String s = "hello world";
        System.out.println("s="+s);
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        char[] val = (char[])value.get(s);
        val[5]='_';
        System.out.println("s="+s);
        Person p = new Person("张三");
        System.out.println(p.name);
        changeName(p);
        System.out.println(p.name);

    }
    static void changeName(Person p){
        p.name = "李四" ;
    }
}
class Person{
    String name;
    Integer age;

    public Person(String name) {
        this.name = name;
    }
}
