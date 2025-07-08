package ex;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 국가재난지원금
		System.out.print("인원 수를 입력하시오 -->");
		int family = sc.nextInt();
		if (family < 4) {
			System.out.printf("%,d지원", 400000 + 200000 * (family - 1));
		} else if (family == 4) {
			System.out.println("1,000,0000원 지원");
		} else {
			System.out.println("1,000,0000원 지원");
		}
		//2. 전기 요금 계산
		// 단가 & 기본 요금
		double[][] fee = {{99.3, 910}, {187.9, 1600}, {280.6, 7300}};
		System.out.print("전기 사용량을 입력하시오 -->");
		double kwh = sc.nextDouble();
		int idx;
		if (kwh <= 200) {
			idx = 0;
		} else if (kwh > 200 && kwh <= 400) {
			idx = 1;
		} else {
			idx = 2;
		}
		System.out.printf("사용량 %.1f kmh \n", kwh);
		System.out.printf("기본 요금: %.1f 원 \n", fee[idx][1]);
		System.out.printf("단가: %.1f 원 \n", fee[idx][0]);
		System.out.printf("전기 요금: %.1f 원 \n", fee[idx][1] + kwh * fee[idx][0]);
	}
}