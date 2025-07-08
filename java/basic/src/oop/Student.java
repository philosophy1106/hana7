package oop;

public class Student extends Person {
	private String program;
	private int year;
	private double fee;

	public Student(String name, String addr, String program, int year, double fee) {
		super(name, addr);
		this.program = program;
		this.year = year;
		this.fee = fee;
	}

	public String getProgram() {
		return this.program;
	}

	public int getYear() {
		return this.year;
	}

	public double getFee() {
		return this.fee;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [program=" + program + ", year=" + year + ", fee=" + fee + "]";
	}

	public static void method(Person p) {
		Student student = (Student)p;
		System.out.println("Down Casting!!");
	}

	public static void main(String[] args) {
		Person p1 = new Person("Hong", "Seoul");
		Person p2 = new Student("Kim", "Busan", "xx", 2025, 2000);

	}
}