package se.java8.optional;

import java.util.Optional;

public class Op {
	public static void main(String[] args) {
		Integer a = null;
		Integer b = 10;

		// Optional.ofNullable - 允许传递为 null 参数
		Optional<Integer> opta = Optional.ofNullable(a);

		// Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
		Optional<Integer> optb = Optional.of(b);

		System.out.println(Op.sum(opta, optb));

	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println(a.isPresent());
		// Optional.orElse - 如果值存在，返回它，否则返回默认值
		Integer value = a.orElse(new Integer(0));
		Integer value2 = b.get();
		return value + value2;
	}
}
