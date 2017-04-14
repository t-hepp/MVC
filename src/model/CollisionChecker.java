package model;

public class CollisionChecker implements Runnable {

    private Ball ball;
    private Paddle paddle;

    public CollisionChecker(final Ball ball, final Paddle paddle) {
        this.ball = ball;
        this.paddle = paddle;
    }

    @Override
    public void run() {

        while (true) {
            // System.out.println("Type: " + paddle.getType());
            // System.out.println("CL crossed: " +
            // paddle.isCollidingWithBallX(ball));
            try {
                Thread.sleep(5);
            }
            catch (final Exception ex) {}

            if (paddle.isCollidingWithBallX(ball) && paddle.isCollidingWithBallY(ball)) {
                ball.setVx(paddle.getReboundDirection() * Math.abs(ball.getVx()));
                // TODO angle
                rebound();
                try {
                    Thread.sleep(30);
                }
                catch (final Exception ex) {}
            }

        }

    }

    private void rebound() {
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

}
