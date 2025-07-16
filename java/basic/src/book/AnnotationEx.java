package book;

public class AnnotationEx {
	public static void main(String[] args) {
		// 리플렉션을 이용한 어노테이션 정보 읽기
		Class<MyBook> clazz = MyBook.class;
		if (clazz.isAnnotationPresent(Book.class)) {
			Book bookAnnotation = clazz.getAnnotation(Book.class);
			System.out.println("Book Title: " + bookAnnotation.title());
			System.out.println("Book Author: "
				+ bookAnnotation.author());
		} else {
			System.out.println("Book annotation not present.");
		}
	}
}