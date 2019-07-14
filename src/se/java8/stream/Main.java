package se.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		// Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
		// limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
		Random random = new Random();
		random.ints().limit(1).forEach(System.out::println);

		// map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> squresList = numbers.stream().map(x -> x + 2).collect(Collectors.toList());
		squresList.forEach(System.out::print);
		System.out.println();
		// filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		long count = strings.stream().filter(string -> string == "abc").count();
		System.out.println(count);

		// sorted用于排序
		Random random2 = new Random();
		random2.ints().limit(3).sorted().forEach(System.out::println);

		// reduce (不断迭代、与python map/reduce 类似)
		int[] myArry = { 1, 3, 5, 10 };
		System.out.println(Arrays.stream(myArry).reduce(0, (a, b) -> a+b));
	}
}
