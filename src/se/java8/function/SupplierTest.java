package se.java8.function;

import java.util.function.Supplier;

/**
 * @author sukbear
 * @create 2018-12-17 16:24
 */
public class SupplierTest {
    static class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User() {
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

        @Override
        public String toString() {
            return this.name +" "+this.age;
        }
    }

    public static void main(String[] args) {
        Supplier<User> sp = ()-> new User("Default name",0);
        User[] users = new User[20];
        for(int i = 0;i <users.length;i++){
            users[i] = sp.get();
        }
        for(User s : users){
            System.out.println(s.toString());
        }
    }
    /**参数none  返回T类型的对象。
     * 返回的是声明的泛型类型 实例（可以是空构造，可以是override的有参构造，在调用get()时才真正地返回对象）
     * */
}
