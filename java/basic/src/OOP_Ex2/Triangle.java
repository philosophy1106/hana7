package OOP_Ex2;

public class Triangle extends Shape implements GeometricObject {
	protected double base;
	protected double height;

	Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public double calcPerimeter() {
		return base + (Math.sqrt(Math.pow(height, 2) + Math.pow(base * 1 / 2, 2))) * 2;
	}

	@Override
	double calcArea() {
		return base * height;
	}
}