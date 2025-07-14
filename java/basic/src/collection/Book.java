package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Book implements Comparable<Book> {
	public int id;
	public String title;
	public String author;
	public int quantity;

	public Book(int id, String title, String author, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Book otherBooks) {
		return Integer.compare(this.id, otherBooks.id);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", quantity=" + quantity + "]";
	}

	static void wordCount() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};

		for (String s : sample) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
				continue;
			}
			map.put(s, map.get(s) + 1);
		}
		System.out.println(map.size() + " 단어가 있습니다."); // 7
		System.out.println(map.containsKey("to")); // true
		if (Math.random() > 0.5) {
			map.clear();
		}
		System.out.println(map.isEmpty()); // false
		System.out.println(map); // {not=1, to=2, …}

	}

	public static void main(String[] args) {

		Map<Integer, Book> map = new HashMap<>();
		map.put(1, new Book(100, "어린왕자", "생텍쥐페리", 5));
		map.put(2, new Book(200, "행복한 왕자", "오스카와일드", 58));
		map.put(3, new Book(300, "셜록 홈즈", "코난 도일", 10));
		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			int key = entry.getKey();
			Book value = entry.getValue();
			System.out.println("key= " + key + " value= " + value.toString());
		}

		System.out.println("map = " + map);
		Set<Integer> keys = map.keySet();
		Collection<Book> values = map.values();
		List<Integer> keyList = new ArrayList<Integer>(keys);
		Collections.sort(keyList);
		System.out.println("keyList= " + keyList);

		Collection<Book> books = map.values();
		List<Book> bookList = new ArrayList<>(books);
		Collections.sort(bookList);
		System.out.println("bookList = " + bookList);
		Collections.reverse(bookList);
		System.out.println("bookList = " + bookList);
	}

}