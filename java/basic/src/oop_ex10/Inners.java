package oop_ex10;

import java.util.Arrays;
import java.util.Comparator;

@FunctionalInterface
interface InterFace {
	public abstract void print(String string);
}

interface MakeIntArray {
	int[] make();
}

class Outer {
	//InterFace inter = (String string) -> System.out.print("%s");
	InterFace inter = System.out::println;
	MakeIntArray make = () -> new int[5];

	void print() {
		inter.print("K");
	}
}

public class Inners {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.print();

		Comparator<String> cpLen = (String str1, String str2) -> str1.length() - str2.length();
		Comparator<String> cpToInt = Comparator.comparingInt(Integer::parseInt);
		String[] strings = {"1", "03", "002"};
		Arrays.sort(strings, cpLen);
		System.out.println(Arrays.toString(strings));
		Arrays.sort(strings, cpToInt);
		System.out.println(Arrays.toString(strings));
	}
}