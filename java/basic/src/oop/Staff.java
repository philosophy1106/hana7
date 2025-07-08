package oop;

public class Staff extends Person {
	private String school;
	private double pay;

	public Staff(String name, String addr, String school, double pay) {
		super(name, addr);
		this.school = school;
		this.pay = pay;
	}

	public String getSchool() {
		return this.school;
	}

}