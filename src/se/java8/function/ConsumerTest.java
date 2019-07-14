package se.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author sukbear
 * @create 2018-12-17 15:40
 */
public class ConsumerTest {
    static class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
        public void print(){
            System.out.println("name: "+this.name+"  age: "+this.age);
        }
    }
    public static void main(String[] args) {
        Consumer<User> con = User::print;
        User user = new User("Tom",20);
        con.accept(user);
        Consumer<User> consumer =  u ->u.setAge(25);
        consumer.accept(user);
        System.out.println(user.getAge());

        List<User> list = new ArrayList<>(3);
        User user1 = new User("Jack",20);
        User user2 =new User("Jan",21);
        list.add(user2);
        list.add(user1);
        list.add(user);
        list.forEach(User::print);
        List<String> strList = new ArrayList<>();
        strList.add("demo");
        strList.add("test");
        strList.forEach(System.out::println);

        /**
         *
         * 参数T 返回
         * 用于接收一个对象进行处理但没有返回(void)，accept()用于接收对象。
         *
         * 返回值为void的方法。
         *
         * User::print【】
         * Consumer<User> consumer =  u ->u.setAge(25);一般方法
                * 集合流处理的foreach的参数就是一个consumer(? super T) 也就是你指定的类型里的void方法
                * out实例的println方法就是返回值为空。
         * */
    }
}
