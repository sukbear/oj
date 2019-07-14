package se.concurrent.AtomicReferenceTest;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/***
 *@ClassName AtomicIntegerField_Updater
 *@Description
 * @author sukbear
 * @create 2019-03-22 10:24
 */
public class AtomicIntegerField_Updater {
    public static void main(String[] args) {
        User user = new User("Jack", 20);
        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

        System.out.println(a.get(user));
        System.out.println(a.compareAndSet(user,Integer.valueOf(20),Integer.valueOf(21)));
    }
}

/**
 *
要想原子地更新对象的属性需要两步。
 第一步，因为对象的属性修改类型原子类都是抽象类，
 所以每次使用都必须使用静态方法 newUpdater()创建一个更新器，
 并且需要设置想要更新的类和属性。
 第二步，更新的对象属性必须使用 public volatile 修饰符。字段必须是基本数据类型

*/


class User {
    private String name;
    public volatile int age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}