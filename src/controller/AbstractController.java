package controller;

import java.util.EventListener;

import controller.bot.AbstractBot;
import model.IModel;
import model.Paddle;

public abstract class AbstractController implements IController {

    private final IModel model;
    private final Paddle left;
    private final Paddle right;

    private EventListener listener = null;

    public AbstractController(final IModel model) {
        this.model = model;
        left = model.getLeftPaddle();
        right = model.getRightPaddle();

    }

    public AbstractController(final IModel model, final AbstractBot bot) {
        this(model);
        if (bot != null) {
            initializeAndAddBot(bot);
        }

    }

    public void initializeAndAddBot(final AbstractBot bot) {
        bot.init(right, model.getBall(), this);
        new Thread(bot).start();

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

    @Override
    public void dispose() {
        leftUpReleased();
        leftDownReleased();
        rightUpReleased();
        rightDownReleased();
    }

    public Paddle getLeft() {
        return left;
    }

    public Paddle getRight() {
        return right;
    }

    public EventListener getListener() {
        return listener;
    }

    public void setListener(final EventListener listener) {
        this.listener = listener;
    }

}
