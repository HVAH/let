package com.vah.let.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/23 11:17
 * @Version 1.0
 */
public class T1 {
	public static void main(String[]args){
		Long value = Long.valueOf("1111");
		Long value2 = Long.valueOf("1111");

		System.out.println("包装类用==比较基本类型");
		System.out.println("Long.valueOf(\"1111\") == 1111 " + (value == 1111));
		System.out.println("Long.valueOf(\"1111\") == 1111L " + (value == 1111L));
		System.out.println("Long.valueOf(\"1111\") == 1111D " + (value == 1111D));

		System.out.println("包装类用equls比较基本类型");
		System.out.println(value.equals(1111));
		System.out.println(value.equals(1111L));
		System.out.println(value.equals(1111D));

		System.out.println("包装类用==比较包装类");
		System.out.println(value2 == value);
		System.out.println("包装类用equls比较包装类");
		System.out.println(value2.equals(value));

		System.out.println(Math.abs((int)Math.pow(-2, 31)));


		List l = null;
		f(l);
		System.out.println(l);


		System.out.println(new Integer(1000) == 1000D);

		System.out.println("=============================");
		String s = null; // no error.
		System.out.println(s.valueOf(0)); // 没有npe，因为对于静态方法的调用编译器会转为String.valueOf(int)

		System.out.println(value++);
		System.out.println(++value);
	}

	private static void f(List list) {
		if (list == null) {
			list = new ArrayList();
		}
	}
}
