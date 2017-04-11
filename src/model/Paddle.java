package model;

public class Paddle extends Moveable {

	private double width;
	private double height;
	private static final int HEIGHT_MULTIPLICATOR = 5;
	private static final double START_Y = 0.5 - (DEFAULT_SIZE * HEIGHT_MULTIPLICATOR / 2);
	private static final double START_X_LEFT = 0.05;
	private static final double START_X_RIGHT = 0.95 - DEFAULT_SIZE;

	public Paddle(PaddleType type) {
		this.setWidth(DEFAULT_SIZE);
		this.setHeight(DEFAULT_SIZE * HEIGHT_MULTIPLICATOR);

		this.setY(START_Y);
		if (type == PaddleType.LEFT) {
			this.setX(START_X_LEFT);
		}
		if (type == PaddleType.RIGHT) {
			this.setX(START_X_RIGHT);
		}

	}

	public void verticalCollision() {
		if (y < 0 && getVy() < 0) {
			setVy(0);
		}
		if (y + height > 1 && getVy() > 0) {
			setVy(0);
		}
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

	static enum PaddleType {
		LEFT, RIGHT
	}

}
