package OOP_Ex2;

class Circle extends Shape implements GeometricObject {
	protected double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcPerimeter() {
		return Math.PI * radius * 2;
	}

	@Override
	public double calcArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle{" +
			"radius=" + radius +
			'}';
	}
}