package OOP_Ex2;

public class ResizableTriangle extends Triangle implements Resizeable {
	ResizableTriangle(double base, double height) {
		super(base, height);
	}

	@Override
	public void resize(int percent) {
		this.base += (this.base * percent / 100);
		this.height += (this.height * percent / 100);
	}
}