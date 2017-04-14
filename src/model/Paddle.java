package model;

public class Paddle extends Moveable {

    private double width;
    private double height;
    private static final int HEIGHT_MULTIPLICATOR = 5;
    private static final double START_Y = 0.5 - (DEFAULT_SIZE * HEIGHT_MULTIPLICATOR / 2);
    private static final double START_X_LEFT = 0.05;
    private static final double START_X_RIGHT = 0.95 - DEFAULT_SIZE;

    private final PaddleType type;

    public Paddle(final PaddleType type) {
        this.type = type;
        setWidth(DEFAULT_SIZE);
        setHeight(DEFAULT_SIZE * HEIGHT_MULTIPLICATOR);

        setY(START_Y);
        if (type == PaddleType.LEFT) {
            setX(START_X_LEFT);
        }
        if (type == PaddleType.RIGHT) {
            setX(START_X_RIGHT);
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

    public boolean isCollidingWithBallX(final Ball ball) {
        if (type == PaddleType.LEFT) {
            return ball.getX() < (getX() + getWidth());
        }
        else {
            return (ball.getX() + 2 * ball.getRadius()) > getX();
        }
    }

    public boolean isCollidingWithBallY(final Ball ball) {
        return (ball.getCenterY() > getY()) && (ball.getCenterY() < (getY() + getHeight()));
    }

    public int getReboundDirection() {
        if (type == PaddleType.LEFT) {
            return 1;
        }
        else {
            return -1;
        }

    }

    public double collisionOrientation(final Ball ball) {
        //        return (ball.getCenterY() - (getY() + getHeight() / 2)) / (getHeight() / 2);
        return (((ball.getCenterY() - getY()) / getHeight()) - 0.5) * 2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(final double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    public PaddleType getType() {
        return type;
    }

    static enum PaddleType {
        LEFT,
        RIGHT
    }

}
