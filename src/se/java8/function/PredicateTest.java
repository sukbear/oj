package se.java8.function;

import java.util.function.Predicate;

/**
 * @author sukbear
 * @create 2018-12-17 15:40
 */
public class PredicateTest {
    static class User {
        private String name;
        private Integer age;

        public boolean isAgeMoreThan20() {
            return this.age > 20;
        }

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
    }

    public static void main(String[] args) {
        Predicate<String> predicateStringLenth = s -> s.length()>10;
        String s = "qwertyuioasdf";
        boolean b = predicateStringLenth.test(s);
        System.out.println(b);
        User user = new User("Jack", 20);
        Predicate<User> predicateAge = User::isAgeMoreThan20;
        System.out.println(predicateAge.test(user));
    }

    /**
     * 参数T 返回boolean
     * predicate 唯一抽象方法 抽象方法test() 返回一个Boolean值 所以初始化的时候，只要你的方法返回的是boolean就行
     * User::isAgeMoreThan20(类的bool方法)
     * Predicate<String> predicateStringLenth = s -> s.length()>10;（一般方法）
     * 通过test（）传入参数。
     * 还有其他默认方法。。。
     * */
}
