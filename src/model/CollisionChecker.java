package model;

import java.awt.geom.Point2D;
import java.util.Random;

public class CollisionChecker implements Runnable {

    private Ball ball;
    private Paddle left;
    private Paddle right;
    private final int refreshRate;

    private Random random = new Random();

    public CollisionChecker(final IModel model) {
        ball = model.getBall();
        left = model.getLeftPaddle();
        right = model.getRightPaddle();
        refreshRate = model.getRefreshRate();
    }

    @Override
    public void run() {

        Paddle paddle = null;

        while (true) {

            if (!Thread.interrupted()) {
                continue;
            }

            if (ball.getVx() >= 0) {
                paddle = right;
            }
            else if (ball.getVx() < 0) {
                paddle = left;
            }
            else {
                continue;
            }

            //Left-Right Collision
            if (paddle.isCollidingWithBallHorizontallyX(ball) && paddle.isCollidingWithBallHorizontallyY(ball)) {
                ball.setVx(paddle.getReboundDirection() * Math.abs(ball.getVx()));
                // TODO angle
                rebound(paddle);
                continue;
            }

            //Up-Down Collision
            if (paddle.isCollidingWithBallVerticallyX(ball) && paddle.isCollidingWithBallVerticallyY(ball)) {
                if (ball.getVy() > 0 && ball.getY() < paddle.getY()) {
                    ball.setVy(-Math.abs(ball.getVy()));
                    System.out.println(paddle.getType());
                }
                if (ball.getVy() < 0 && ball.getY() > paddle.getY()) {
                    ball.setVy(Math.abs(ball.getVy()));
                    System.out.println(paddle.getType());
                }

                continue;
            }

            //TODO corner collision
            final Point2D corner;
            final double y;
            if (ball.getVy() > 0) {
                y = paddle.getY();
            }
            else {
                y = paddle.getY() + paddle.getHeight();
            }
            corner = new Point2D.Double(paddle.getX(), y);
            final Point2D center = ball.getCenter();
            final double distance = center.distance(corner);
            if (distance < ball.getRadius()) {
                final double c = -2 * (ball.getVx() * center.getX() + ball.getVy() * center.getY()) / (center.getX() * center.getX() + center.getY() * center
                                                                                                                                                             .getY());
                ball.setVx(ball.getVx() + c * center.getX());
                ball.setVy(ball.getVy() + c * center.getY());
                System.out.println("CORNER" + "  ---  " + paddle.getType());
                sleep(100);
                continue;
            }

        }

    }

    private void rebound(final Paddle paddle) {
        final double vx = ball.getVx();
        final double vy = ball.getVy();
        final double speed = ball.getSpeed();
        final double maxDiff = speed / 2;
        double vyNew = vy + paddle.collisionOrientation(ball) * speed;

        //        System.out.println(paddle.collisionOrientation(ball) * speed);
        //        System.out.println(paddle.getType());

        final double newSpeed = Math.sqrt(vx * vx + vyNew * vyNew);
        vyNew = vyNew * (speed / newSpeed);
        final double vxNew = vx * (speed / newSpeed);

        System.out.println(ball.getSpeed());
        ball.setVy(vyNew);
        ball.setVx(vxNew);
        ball.incrementSpeed();
        System.out.println(ball.getSpeed());

    }

    private void sleep() {
        try {
            Thread.sleep(10);
        }
        catch (final Exception ex) {}
    }

    private void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (final Exception ex) {}
    }

}
