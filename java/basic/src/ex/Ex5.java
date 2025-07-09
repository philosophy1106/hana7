package ex;

public class Ex5 {
	public static void main(String[] args) {
		for (int i = 1; i <= 19; i++) {
			for (int j = 11; j <= 19; j++) {
				System.out.printf("%d * %d =%3d ", j, i, i * j);
			}
			System.out.println("\n");
		}
	}
}