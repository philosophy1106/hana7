package OOP_Ex2;

public class ResizeableCircle extends Circle implements Resizeable {

	ResizeableCircle(double radius) {
		super(radius);
	}

	@Override
	public void resize(int percent) {
		this.radius += (this.radius * percent / 100);
	}

	@Override
	public String toString() {
		return "ResizeableCircle[" + super.toString() + "]";
	}

}