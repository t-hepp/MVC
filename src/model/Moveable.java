package model;

public class Moveable {

    protected double x;
    protected double y;

    protected double vx;
    protected double vy;

    public static final double DEFAULT_SIZE = 0.02;
    public static final double DEFAULT_SPEED = 0.0075;

    public void move() {
        setX(x + vx);
        setY(y + vy);
    }

    public double getX() {
        return x;
    }

    public void setX(final double d) {
        x = d;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(final double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(final double vy) {
        this.vy = vy;
    }

}
