package controller.bot;

import controller.IController;
import model.Ball;
import model.Paddle;

public abstract class AbstractBot implements Runnable {

    private Paddle paddle;
    private Ball ball;
    private IController controller;

    private boolean initialized = false;

    @Override
    public abstract void run();

    public void init(final Paddle paddle, final Ball ball, final IController controller) {
        setPaddle(paddle);
        setBall(ball);
        setController(controller);
        initialized = true;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(final Paddle paddle) {
        this.paddle = paddle;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(final Ball ball) {
        this.ball = ball;
    }

    public IController getController() {
        return controller;
    }

    public void setController(final IController controller) {
        this.controller = controller;
    }

    public boolean isInitialized() {
        return initialized;
    }

}
