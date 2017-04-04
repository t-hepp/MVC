package model;

import java.awt.Point;

public class Ball {

	private double x;
	private double y;

	private double vx;
	private double vy;

	private int radius;
	public static final int DEFAULT_RADIUS = 10;
	public static final double DEFAULT_SPEED = 0.005;

	public Ball() {
		this(0.5, 0.5);
	}

	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;

		this.radius = DEFAULT_RADIUS;
	}

	public void move() {
		setX(x + vx);
		setY(y + vy);
	}

	public void checkCollision(int windowWidth, int windowHeight) {
		if (collision(windowWidth, windowHeight) == BorderCollisionType.TOP) {
			System.out.println("top");
			vy = Math.abs(vy);
		}
		if (collision(windowWidth, windowHeight) == BorderCollisionType.BOTTOM) {
			vy = -Math.abs(vy);
		}
		if (collision(windowWidth, windowHeight) == BorderCollisionType.LEFT) {
			System.out.println("left");
			vx = Math.abs(vx);
		}
		if (collision(windowWidth, windowHeight) == BorderCollisionType.RIGHT) {
			System.out.println("right");
			vx = -Math.abs(vx);
		}
	}

	private BorderCollisionType collision(int windowWidth, int windowHeight) {
		if (isCollidingTop()) {
			return BorderCollisionType.TOP;
		}
		if (isCollidingBottom(windowHeight)) {
			return BorderCollisionType.BOTTOM;
		}
		if (isCollidingLeft(windowWidth)) {
			return BorderCollisionType.LEFT;
		}
		if (isCollidingRight(windowWidth)) {
			return BorderCollisionType.RIGHT;
		}
		return null;
	}

	private boolean isCollidingTop() {
		return y <= 0;
	}

	private boolean isCollidingBottom(int windowHeight) {
		return (getYAbs(windowHeight) + radius * 2) >= windowHeight;
	}

	private boolean isCollidingLeft(int windowWidth) {
		return x <= 0;
	}

	private boolean isCollidingRight(int windowWidth) {
		return (getXAbs(windowWidth) + radius * 2) >= windowWidth;
	}

	public int getXAbs(int windowWidth) {
		return (int) Math.round(x * windowWidth);
	}

	public void setXAbs(int x, int windowWidth) {
		setX((double) x / windowWidth);
	}

	public int getYAbs(int windowHeight) {
		return (int) Math.round(y * windowHeight);
	}

	public void setYAbs(int y, int windowHeight) {
		setY((double) y / windowHeight);
	}

	public Point getCenterAbs(int windowWidth, int windowHeight) {
		int x = getXAbs(windowWidth) + radius;
		int y = getYAbs(windowHeight) + radius;
		return new Point(x, y);
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void incrementSpeed() {
		vx *= 1.003;
		vy *= 1.001;

	}

}
