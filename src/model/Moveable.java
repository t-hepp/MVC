package model;

public class Moveable {

	protected double x;
	protected double y;

	protected double vx;
	protected double vy;

	public static final double DEFAULT_SIZE = 0.02;
	public static final double DEFAULT_SPEED = 0.005;

	public void move() {
		setX(x + vx);
		setY(y + vy);
	}

	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

}
