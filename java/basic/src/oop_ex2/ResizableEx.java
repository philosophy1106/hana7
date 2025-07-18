package oop_ex2;

public class ResizableEx {
	public static void main(String[] args) {
		Circle circle = new Circle(2.0);
		System.out.printf("%s의 둘레는 %.1f 면적은 %.1f %n", circle, circle.calcPerimeter(), circle.calcArea());
		System.out.println("-----------------------------------------");
		ResizeableCircle reCircle = new ResizeableCircle(3.0);
		System.out.printf("%s의 둘레는 %.1f 면적은 %.1f %n", reCircle, reCircle.calcPerimeter(), reCircle.calcArea());
		reCircle.resize(10);
		System.out.println("-----------------------------------------");
		System.out.println("크기를 10퍼센트 크게 변경 후");
		System.out.printf("%s의 둘레는 %.1f 면적은 %.1f %n", reCircle, reCircle.calcPerimeter(), reCircle.calcArea());
	}
}