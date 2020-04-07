package aaa;

import java.util.Comparator;

public class LambadaTest {

	public static void main(String[] args) {
		//匿名内部类
		new Thread(() ->  {
			System.out.println("***************");
			System.out.println("###############");
		}).start();
		//实现接口
		Comparable<Integer> com = (a) -> a+1;
		System.out.println(com.compareTo(3));
		Comparator<Integer> compator = (b,c) -> b+c;
		System.out.println(compator.compare(1,2));
	}

}
