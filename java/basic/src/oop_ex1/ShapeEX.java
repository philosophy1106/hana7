package oop_ex1;

public class ShapeEX {
	public static void main(String[] args) {
		Shape[] shapes = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
		double sum = 0;
		for (Shape s : shapes) {
			sum += s.calArea();
		}
		System.out.println(sum);
	}
}