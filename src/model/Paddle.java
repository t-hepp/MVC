package model;

public class Paddle extends Moveable {

	private double width;
	private double height;
	private static final int HEIGHT_MULTIPLICATOR = 5;

	public Paddle() {
		this.setWidth(DEFAULT_SIZE);
		this.setHeight(DEFAULT_SIZE * HEIGHT_MULTIPLICATOR);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
