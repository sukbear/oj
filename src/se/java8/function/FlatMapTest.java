package se.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sukbear
 * @create 2018-12-17 17:20
 */
public class FlatMapTest {
    public static void main(String[] args) {
        /**
         * 合并流，将能合并的流合并在一起。
         * */
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> all = Stream.of(list1, list2).flatMap(List::stream).collect(Collectors.toList());
        all.forEach(System.out::println);
    }

}
