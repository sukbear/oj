package se.other.generic;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author sukbear
 * @create 2018-12-17 10:44
 */
public class PredicateAndConsumer {
    boolean sb() {
        return true;
    }

    static class User {
        private String name;
        private Integer age;
        private String address;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User(String name, Integer age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String adress) {
            this.address = adress;
        }

        @Override
        public String toString() {
            return "name: " + this.name + "  age: " + this.age + "  address: " + this.address;
        }

        public void print() {
            System.out.println(this.getName());
        }
    }

    public static void main(String[] args) {
        Predicate<User> isAgeSurpassTwenty = u -> u.getAge() > 20;
        User user = new User("tom", 21);
        boolean bool = isAgeSurpassTwenty.test(user);
        System.out.println(bool);
        Consumer<User> op = u -> u.setAddress("安道尔");
        op.accept(user);
        Consumer<User> opUser = u -> u.print();
        opUser.accept(user);
    }
}
