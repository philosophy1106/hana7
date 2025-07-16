package oop_ex10;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {
	public static void main(String[] args) {
		List<Integer> list = List.of(10, 6, 3, 3, 5, 4, 2, 7, 7, 9, 8, 10);
		System.out.println("짝수의 개수");
		System.out.println(list.stream().filter(i -> i % 2 == 0).count());
		System.out.println("각 숫자를 제곱");
		System.out.println(list.stream().map(i -> i * i).toList());
		System.out.println("중복 제거");
		System.out.println(list.stream().distinct().toList());
		System.out.println("기본 정렬");
		System.out.println(list.stream().sorted().toList());
		System.out.println("역순(내림차순) 정렬");
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());
		System.out.println("처음 5개만 출력");
		System.out.println(list.stream().limit(5).toList());
		System.out.println("처음 5개 건너뛰고 출력");
		System.out.println(list.stream().skip(5).toList());
		System.out.println("값이 5보다 큰 것만 출력");
		System.out.println(list.stream().filter(i -> i > 5).toList());
		System.out.println("전체 합계 / 전체 평균");
		System.out.println(list.stream().reduce(Integer::sum).orElse(0));
		System.out.println(list.stream().mapToInt(Integer::intValue).average().orElse(0));
		System.out.println("1~10의 합계"); //숫자 1부터 10까지 합
		System.out.println(IntStream.rangeClosed(1, 10));
		System.out.println("랜덤 5개의 평균");
		System.out.println(
			"Stream.generate(Math::random).limit(5).mapToDouble(Double::doubleValue).average() = " + Stream.generate(
				Math::random).limit(5).mapToDouble(Double::doubleValue).average());
		Optional<Integer> f5 = list.stream().filter(n -> n > 5).findFirst();
		System.out.println("f5 = " + f5 + ", " + f5.isEmpty());
	}
}