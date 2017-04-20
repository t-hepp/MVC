package controller;

import java.util.EventListener;

import controller.bot.AbstractBot;
import model.IModel;
import model.Paddle;

public class ConstantSpeedController extends AbstractController {

    public ConstantSpeedController(final IModel model, final AbstractBot bot) {
        super(model, bot);
    }

    @Override
    public EventListener getEventListener() {
        return new PongKeyListener(this);
    }

    @Override
    public InputType getInputType() {
        return InputType.KEY;
    }

    @Override
    public void leftUpPressed() {
        getLeft().setVy(-Paddle.DEFAULT_SPEED);
    }

    @Override
    public void leftUpReleased() {
        getLeft().setVy(0);
    }

    @Override
    public void leftDownPressed() {
        getLeft().setVy(Paddle.DEFAULT_SPEED);
    }

    @Override
    public void leftDownReleased() {
        getLeft().setVy(0);
    }

    @Override
    public void rightUpPressed() {
        getRight().setVy(-Paddle.DEFAULT_SPEED);
    }

    @Override
    public void rightUpReleased() {
        getRight().setVy(0);
    }

    @Override
    public void rightDownPressed() {
        getRight().setVy(Paddle.DEFAULT_SPEED);
    }

    @Override
    public void rightDownReleased() {
        getRight().setVy(0);

    }

}
