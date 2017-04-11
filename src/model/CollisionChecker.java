package model;

public class CollisionChecker implements Runnable {

	private Ball ball;
	private Paddle paddle;

	public CollisionChecker(Ball ball, Paddle paddle) {
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
				Thread.sleep(10);
			} catch (Exception ex) {
			}

			if (paddle.isCollidingWithBallX(ball) && paddle.isCollidingWithBallY(ball)) {
				ball.setVx(paddle.getReboundDirection() * Math.abs(ball.getVx()));
				// TODO angle
			}

		}

	}

}
