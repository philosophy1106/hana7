package oop;

import java.util.Scanner;

public class Employee {
	private final int id;
	private final String name;
	private int salary;

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnnualSalary() {
		return this.salary * 12;
	}

	public int raiseSalary(int percent) {
		int raise = (this.salary * percent) / 100;
		this.salary += raise;
		return raise;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static final int[] rate = {10, 20, 30};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee[] employees = new Employee[3];
		for (int i = 0; i < rate.length; i++) {
			String str = sc.nextLine();
			String[] param = str.split("\\s+");
			employees[i] = new Employee(i + 1, param[0], Integer.parseInt(param[1]));
		}

		for (int i = 0; i < rate.length; i++) {
			System.out.printf("%s의 연봉은 %d 월급 인상분은 %d \n",
				employees[i].toString(), employees[i].getAnnualSalary(), employees[i].raiseSalary(rate[i]));
		}
	}
}