package OOP_Ex1;

class Circle extends Shape {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double calArea() {
		return Math.PI * radius * radius;
	}
}