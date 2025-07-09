package oop;

public abstract class Car {
	public Car() {
		System.out.println("Car object 생성");
	}

	abstract void run();

	void start() {
		System.out.println("시동을 건다");
	}
}

class Porche extends Car {
	@Override
	public void run() {
		System.out.println("포르셰가 달린다");
	}

	@Override
	public void start() {
		System.out.println("포르셰가 시동을 건다");
	}
}

class CarEx {
	public static void main(String[] args) {
		Car car = new Porche();
		car.run();
		car.start();
	}
}