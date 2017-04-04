package model;

public class Ball extends Moveable {

	private double radius;

	public Ball() {
		this(0.5, 0.5);
	}

	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
		this.vx = 0.005;
		this.vy = 0;

		this.radius = DEFAULT_SIZE;
	}

	@Override
	public void move() {
		setX(x + vx);
		setY(y + vy);
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double d) {
		this.x = d;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getVx() {
		return vx;
	}

	@Override
	public void setVx(double vx) {
		this.vx = vx;
	}

	@Override
	public double getVy() {
		return vy;
	}

	@Override
	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void incrementSpeed() {
		vx *= 1.003;
		vy *= 1.001;

	}

}
