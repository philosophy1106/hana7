package collection;

import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		map.put("love", "사랑");
		map.put("apple", "사과");
		map.put("baby", "아기");
		while (true) {
			System.out.print("찾고 싶은 단어는?");
			String word = sc.nextLine();
			System.out.println(map.get(word));
		}
	}
}