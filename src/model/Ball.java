package model;

import java.awt.geom.Point2D;
import java.util.Random;

public class Ball extends Moveable {

	private double radius;

	static final Point2D START_POSITION = new Point2D.Double(0.5 - DEFAULT_SIZE, 0.5 - DEFAULT_SIZE);

	private Random random = new Random();

	public Ball() {
		this.x = START_POSITION.getX();
		this.y = START_POSITION.getY();
		this.vx = 0;
		this.vy = 0;
		this.radius = DEFAULT_SIZE;
	}

	@Override
	public void move() {
		setX(x + vx);
		setY(y + vy);
	}

	public void verticalCollision() {
		if (y < 0) {
			setVy(Math.abs(getVy()));
		}
		if (y + 2 * radius > 1) {
			setVy(-Math.abs(getVy()));
		}
		// if (x + 2 * radius > 1) {
		// setVx(-Math.abs(getVx()));
		// }
	}

	public boolean isLeft() {
		return x + 2 * radius < 0;
	}

	public boolean isRight() {
		return x > 1;
	}

	public void reset() {
		this.x = START_POSITION.getX();
		this.y = START_POSITION.getY();
		this.vx = 0;
		this.vy = 0;
		this.radius = DEFAULT_SIZE;
	}

	public void restart() {
		vy = (random.nextBoolean() ? 1 : -1) * random.nextDouble() * DEFAULT_SPEED * 0.75;
		vx = (random.nextBoolean() ? 1 : -1) * Math.sqrt(DEFAULT_SPEED * DEFAULT_SPEED - vy * vy);
		// vx = DEFAULT_SPEED;
	}

	public double getCenterX() {
		return getX() + getRadius();
	}

	public double getCenterY() {
		return getY() + getRadius();
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
