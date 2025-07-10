package OOP_Ex2;

class Circle implements GeomericObject {
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
	public double getPerimeter() {
		return Math.PI * radius * 2;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle[radius=" + radius + "]]";
	}
}