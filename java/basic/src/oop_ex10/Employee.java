package oop_ex10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
	private String name;
	private float salary;
	private String gender;

	public boolean isFemale() {
		return "F".equals(this.getGender());
	}

	public static void main(String[] args) {
		Employee john = new Employee("John", 1500, "M");
		Employee sarah = new Employee("Sarah", 2000, "F");
		Employee charles = new Employee("Charles", 1700, "M");
		Employee mary = new Employee("Mary", 5000, "F");
		Employee sophie = new Employee("Sophie", 7000, "F");
		List<Employee> employees = Arrays.asList(john, sarah, charles, mary, sophie);
		// Predicate<Employee>: Employee를 입력으로 받아 boolean을 반환하는 함수형
		Predicate<Employee> predicate = e -> e.isFemale() && e.getSalary() > 2500;
		employees //
			.stream() //
			.filter(predicate) // 조건에 맞는 직원만 통과
			.forEach(e -> System.out.println(e.getName() + " : " + e.getSalary()));
	}
}