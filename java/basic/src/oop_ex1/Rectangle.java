package oop_ex1;

class Rectangle extends Shape {
	double width;
	double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double calArea() {
		return width * height;
	}
}