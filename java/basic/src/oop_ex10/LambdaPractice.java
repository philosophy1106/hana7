package oop_ex10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface MyPredicate {
	boolean test(int value);
}

interface MyFunction<T, R> {
	R apply(T t); //제너릭...
}

interface MyReducer {
	int reduce(int num1, int num2);
}

public class LambdaPractice {
	static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
		List<Integer> result = new ArrayList<>();
		for (Integer i : list) {
			if (predicate.test(i)) {
				result.add(i);
			}
		}
		return result;
	}

	static List<Integer> map(List<Integer> list, MyFunction<Integer, Integer> function) {
		List<Integer> result = new ArrayList<>();
		for (Integer i : list) {
			result.add(function.apply(i));
		}
		return result;
	}

	static Integer reducer(List<Integer> list, int initValue, MyReducer predicate) {
		int result = initValue;
		for (Integer i : list) {
			result = predicate.reduce(result, i);
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(numbers);
		List<Integer> evens = filter(numbers, value -> value % 2 == 0);
		System.out.println(evens);
		List<Integer> squares = map(numbers, value -> value * value);
		System.out.println(squares);
		//Integer bigger3 = map(numbers, value -> value > 3);
		List<Integer> bigger3 = filter(numbers, value -> value > 3);
		System.out.println(bigger3);
		int sum = reducer(numbers, 0, (a, b) -> a + b);
		System.out.println(sum);
	}
}