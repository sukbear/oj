package se.java8.function;

import java.util.function.BiFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * @author sukbear
 * @create 2018-12-17 17:30
 */
public class FunctionTest {
    /**
     * compose 和 andThen 的不同之处是函数执行的顺序不同。
     * compose 函数先执行参数，然后执行调用者，而 andThen 先执行调用者，然后再执行参数。
     */
    //泛型方法
    public static <T> T compute(T t1, T t2, BiFunction<T, T, T> function) {
        return function.apply(t1, t2);
    }

    static class MyFunction<T> {
        public T ac(T t1, T t2, BiFunction<T, T, T> action) {
            return action.apply(t1, t2);
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> square = number -> number * number;
        Function<Integer, Integer> two = number -> 2 * number;
        Integer a = square.andThen(two).apply(3);
        Integer b = square.compose(two).apply(3);

        Integer num = FunctionTest.compute(2, 3, (var1, var2) -> var1 + var2);
        String s = FunctionTest.compute("de", "mo", (var1, var2) -> var1 + var2);
        System.out.println(num);
        System.out.println(s);

        DoubleToIntFunction v = value -> new Double(value).intValue();
        System.out.println(v.applyAsInt(10.23));

    }
}
