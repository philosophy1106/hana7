package ex;

import java.util.Scanner;

public class Ex2 {
	static final int MIN = 125;
	static final int MAX = 165;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 문제
		System.out.print("1. 어린이의 신장(cm)을 입력하세요: ");
		int height = sc.nextInt();
		System.out.println(height >= MIN);
		//2. 문제
		System.out.print("2. 어린이의 신장(cm)을 입력하세요: ");
		int height2 = sc.nextInt();
		System.out.println(height2 >= MIN && height2 <= MAX);
	}
}