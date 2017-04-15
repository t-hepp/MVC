package controller;

import java.util.EventListener;

import model.IModel;
import model.Paddle;

public abstract class AbstractController implements IController {

    private final IModel model;
    private final Paddle left;
    private final Paddle right;

    public AbstractController(final IModel model) {
        this.model = model;
        left = model.getLeftPaddle();
        right = model.getRightPaddle();

    }

    public void addBot() {
        new Thread(new PongBot(right, model.getBall(), this)).start();

    }

    @Override
    public abstract EventListener getEventListener();

    @Override
    public abstract InputType getInputType();

    @Override
    public void startModel() {
        model.init();
    }

    @Override
    public void restart() {
        model.restart();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public abstract void leftUpPressed();

    @Override
    public abstract void leftUpReleased();

    @Override
    public abstract void leftDownPressed();

    @Override
    public abstract void leftDownReleased();

    @Override
    public abstract void rightUpPressed();

    @Override
    public abstract void rightUpReleased();

    @Override
    public abstract void rightDownPressed();

    @Override
    public abstract void rightDownReleased();

    public Paddle getLeft() {
        return left;
    }

    public Paddle getRight() {
        return right;
    }

}
