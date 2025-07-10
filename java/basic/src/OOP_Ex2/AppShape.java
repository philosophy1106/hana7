package OOP_Ex2;

//public class AppShape<T extends Shape & Resizeable> {
public class AppShape<T extends Shape> implements Resizeable {
	private final T shape;

	public AppShape(T shape) {
		this.shape = shape;
	}

	public double calcArea() {
		return shape.calcArea();
	}

	public double calcPerimeter() {
		if (shape instanceof GeometricObject) {
			return shape.calcArea();
		} else {
			throw new IllegalArgumentException("shape is not GeometricObject");
		}
	}

	public T getShape() {
		return this.shape;
	}

	@Override
	public String toString() {
		return "AppShape {" + this.shape.getClass().getSimpleName() + "}";
	}

	@Override
	public void resize(int percent) {
		if (shape instanceof Resizeable) {
			((Resizeable)shape).resize(percent);
		} else {
			throw new IllegalStateException("cannot resize");
		}
	}
}