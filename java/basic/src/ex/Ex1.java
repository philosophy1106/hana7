package ex;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = sc.nextLine();
		String address = sc.nextLine();
		int age = sc.nextInt();
		double height = sc.nextDouble();

		System.out.printf("이름 %s \n", name);
		System.out.printf("주소 %s \n", address);
		System.out.printf("나이 %d \n", age);
		System.out.printf("키 %.1f", height);
	}
}