package oop;

public class Person {
	private String name;
	private String addr;

	public Person(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}

	public String getName() {
		return this.name;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + "]";
	}
}