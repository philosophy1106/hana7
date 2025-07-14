package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
	static final String[] GRADE = {"A", "B", "C", "D", "F"};

	static String getGrade(Integer score) {
		return switch (score / 10) {
			case 10, 9 -> GRADE[0];
			case 8 -> GRADE[1];
			case 7 -> GRADE[2];
			case 6 -> GRADE[3];
			default -> GRADE[4];
		};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<>();
		String str;
		while (true) {
			System.out.print("점수를 입력하세요: ");
			int score = 0;
			try {
				score = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("정수를 입력하세요");
				continue;
			}
			if (score < 0) {
				break;
			}
			if (score > 100) {
				System.out.println("잘못된 점수입니다 다시 입력하세요");
				continue;
			}
			al.add(score);
		}
		System.out.println("학생들의 성적: " + al);
		for (int i = 0; i < al.size(); i++) {
			System.out.printf("%d 학생의 성적은 %d점이며 학점은 %s이다 %n", i, al.get(i), getGrade(al.get(i)));
		}

	}
}