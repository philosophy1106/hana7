package oop_ex2;

public class ShapeEX {
	public static void main(String[] args) {
		Shape[] shapes = {
			new Circle(1),
			new ResizeableCircle(2),
			new Rectangle(4, 5),
			new Triangle(6, 4)
		};
		ResizeableCircle reCircle = new ResizeableCircle(3);
		AppShape<ResizeableCircle> appCircle = new AppShape<>(reCircle);
		AppShape<?>[] appShapes = new AppShape[shapes.length];

		for (int i = 0; i < shapes.length; i++) {
			appShapes[i] = new AppShape<>(shapes[i]);
		}

		for (AppShape<?> appShape : appShapes) {
			System.out.println("appShape = " + appShape.toString());
		}
		System.out.printf(" 삼각형 둘레 %.1f %n", appShapes[3].calcPerimeter());
		System.out.println("리사이즈 전  " + appShapes[1].calcPerimeter());
		appShapes[1].resize(10);
		System.out.println("리사이즈 후 " + appShapes[1].calcPerimeter());
	}
}