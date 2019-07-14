package se.other.fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sukbear
 * @create 2018-12-17 10:11
 */
public class Apple extends Fruit {
    private String colour;

    public Apple(String shape, Double weight, String colour) {
        super(shape, weight);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }


    public static void main(String[] args) {

        /**在Java中不允许创建泛型数组，类似下面这样的做法编译器会报错：
         *
         * 我们无法对泛型代码直接使用instanceof关键字，
         * 因为Java编译器在生成代码的时候会擦除所有相关泛型的类型信息，
         * 正如我们上面验证过的JVM在运行时期
         * 无法识别出ArrayList<Integer>和ArrayList<String>的之间的区别：*/
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1.equals(c2));
    }
}
