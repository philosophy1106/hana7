package OOP_Ex2;

public class ResizableRectangle extends Rectangle implements Resizeable {

	public ResizableRectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public void resize(int percent) {
		this.width += (this.width * percent / 100);
		this.height += (this.height * percent / 100);
	}

}