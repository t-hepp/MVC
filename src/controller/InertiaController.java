package controller;

import java.util.EventListener;

import controller.bot.AbstractBot;
import model.IModel;
import model.Paddle;

public class InertiaController extends AbstractController {

    protected InertiaEffect leftInertiaEffect = new InertiaEffect(getLeft(), 0);
    private InertiaEffect rightInertiaEffect = new InertiaEffect(getRight(), 0);

    public InertiaController(final IModel model) {
        super(model);
        new Thread(leftInertiaEffect).start();
        new Thread(rightInertiaEffect).start();
    }

    public InertiaController(final IModel model, final AbstractBot bot) {
        this(model);
        if (bot != null) {
            initializeAndAddBot(bot);
        }
    }

    @Override
    public EventListener getEventListener() {
        if (getListener() == null) {
            setListener(new PongKeyListener(this));
        }
        return getListener();
    }

    @Override
    public InputType getInputType() {
        return InputType.KEY;
    }

    @Override
    public void leftUpPressed() {
        leftInertiaEffect.setDirection(-1);

    }

    @Override
    public void leftUpReleased() {
        leftInertiaEffect.setDirection(0);

    }

    @Override
    public void leftDownPressed() {
        leftInertiaEffect.setDirection(1);

    }

    @Override
    public void leftDownReleased() {
        leftInertiaEffect.setDirection(0);

    }

    @Override
    public void rightUpPressed() {
        rightInertiaEffect.setDirection(-1);

    }

    @Override
    public void rightUpReleased() {
        rightInertiaEffect.setDirection(0);

    }

    @Override
    public void rightDownPressed() {
        rightInertiaEffect.setDirection(1);

    }

    @Override
    public void rightDownReleased() {
        rightInertiaEffect.setDirection(0);

    }

    @Override
    public void dispose() {
        super.dispose();
        leftInertiaEffect.stop();
        rightInertiaEffect.stop();
    }

    private class InertiaEffect implements Runnable {

        private final Paddle paddle;
        private int direction;

        private boolean running = true;

        private static final int RATIO = 60;

        public InertiaEffect(final Paddle paddle, final int direction) {
            this.paddle = paddle;
            this.direction = direction;
        }

        public void stop() {
            running = false;
        }

        @Override
        public void run() {

            while (running) {
                paddle.setVy(paddle.getVy() + 2 * direction * Paddle.DEFAULT_SPEED / RATIO);
                if (paddle.getVy() > Paddle.DEFAULT_SPEED / RATIO) {
                    final double before = paddle.getVy();
                    paddle.setVy(paddle.getVy() - 1 * Paddle.DEFAULT_SPEED / RATIO);
                    final double after = paddle.getVy();
                    //                    System.out.println("dif " + (before - after * 1000000));
                    //                    System.out.println("down inertia " + (-Paddle.DEFAULT_SPEED / RATIO));
                }
                else if (paddle.getVy() < -Paddle.DEFAULT_SPEED / RATIO) {
                    final double before = paddle.getVy();
                    paddle.setVy(paddle.getVy() + Paddle.DEFAULT_SPEED / RATIO);
                    final double after = paddle.getVy();
                    //                    System.out.println("dif " + (before - after * 1000000));
                    //                    System.out.println("up inertia " + (Paddle.DEFAULT_SPEED / RATIO));
                }
                else {
                    paddle.setVy(0);
                }
                try {
                    Thread.sleep(10);
                }
                catch (final Exception ex) {}
            }

        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(final int direction) {
            this.direction = direction;
            //            System.out.println(direction);
        }

    }

}
