package ex;

import java.util.Scanner;

public class Ex4 {
	static final char[] GRADE = {'A', 'B', 'C', 'D', 'F'};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		//1번 문제
		int idx;
		switch (score / 10) {
			case 10, 9 -> idx = 0;
			case 8 -> idx = 1;
			case 7 -> idx = 2;
			case 6 -> idx = 3;
			default -> idx = 4;
		}
		System.out.println(GRADE[idx]);
		//2번 문제
		char grad = sc.next().charAt(0);
		String message = switch (grad) {
			case 'A', 'B' -> "참 잘했음";
			case 'C', 'D' -> "좀 더 노력해";
			default -> "다음 학기에 다시 만나요";
		};
		System.out.println(message);
	}
}