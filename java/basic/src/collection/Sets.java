package collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1100);
		set.add(22);
		set.add(55);
		System.out.println(set);

		Set<Integer> set1 = new TreeSet<>();
		set1.add(1100);
		set1.add(22);
		set1.add(55);
		set1.add(23);
		set1.add(33);
		System.out.println(set1);
	}
}