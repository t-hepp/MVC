package model;

import java.awt.geom.Point2D;
import java.util.Random;

public class Ball extends Moveable {

    private double radius;

    static final Point2D START_POSITION = new Point2D.Double(0.5 - DEFAULT_SIZE, 0.5 - DEFAULT_SIZE);

    private Random random = new Random();

    public Ball() {
        x = START_POSITION.getX();
        y = START_POSITION.getY();
        vx = 0;
        vy = 0;
        radius = DEFAULT_SIZE;
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
        x = START_POSITION.getX();
        y = START_POSITION.getY();
        vx = 0;
        vy = 0;
        radius = DEFAULT_SIZE;
    }

    public void restart() {
        //		vy = (random.nextBoolean() ? 1 : -1) * random.nextDouble() * DEFAULT_SPEED * 0.75;
        //		vx = (random.nextBoolean() ? 1 : -1) * Math.sqrt(DEFAULT_SPEED * DEFAULT_SPEED - vy * vy);
        vx = DEFAULT_SPEED;
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
    public void setX(final double d) {
        x = d;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(final double y) {
        this.y = y;
    }

    @Override
    public double getVx() {
        return vx;
    }

    @Override
    public void setVx(final double vx) {
        this.vx = vx;
    }

    @Override
    public double getVy() {
        return vy;
    }

    @Override
    public void setVy(final double vy) {
        this.vy = vy;
    }

    public double getSpeed() {
        return Math.sqrt(vx * vx + vy * vy);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(final double radius) {
        this.radius = radius;
    }

    public void incrementSpeed() {
        vx *= 1.1;
        vy *= 1.1;

    }

}
