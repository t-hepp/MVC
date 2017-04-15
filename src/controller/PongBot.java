package controller;

import model.Ball;
import model.Paddle;

public class PongBot implements Runnable {

    private Paddle paddle;
    private Ball ball;
    private IController controller;

    public PongBot(final Paddle paddle, final Ball ball, final IController controller) {
        this.paddle = paddle;
        this.ball = ball;
        this.controller = controller;
    }

    @Override
    public void run() {

        while (true) {

            if (Math.abs(ball.getCenterY() - (paddle.getY() + paddle.getHeight() / 2)) < paddle.getHeight() / 4) {
                controller.rightUpReleased();
                controller.rightDownReleased();
            }
            else {
                if (ball.getCenterY() > paddle.getY() + paddle.getHeight() / 2) {
                    controller.rightUpReleased();
                    controller.rightDownPressed();
                }
                else {
                    controller.rightDownReleased();
                    controller.rightUpPressed();
                }
            }
            try {
                Thread.sleep(10);
            }
            catch (final Exception ex) {}
        }
    }
}
