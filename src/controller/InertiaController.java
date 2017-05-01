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
        initializeAndAddBot(bot);
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

    private class InertiaEffect implements Runnable {

        private final Paddle paddle;
        //        private double signum;
        private int direction;

        private static final int RATIO = 120;

        public InertiaEffect(final Paddle paddle, final int direction) {
            this.paddle = paddle;
            //            if (Math.signum(paddle.getVy()) != 0) {
            //                setSignum(Math.signum(paddle.getVy()));
            //            }
            //            else {
            //                setSignum(direction);
            //            }
            this.direction = direction;
        }

        @Override
        public void run() {
            //            while (true) {
            //                paddle.setVy(paddle.getVy() + direction * Paddle.DEFAULT_SPEED / 100);
            //                if (paddle.getVy() > direction * Paddle.DEFAULT_SPEED / 90) {
            //                    direction = 0;
            //                }
            //                try {
            //                    Thread.sleep(10);
            //                }
            //                catch (final Exception ex) {}
            //            }

            while (true) {
                paddle.setVy(paddle.getVy() + 2 * direction * Paddle.DEFAULT_SPEED / RATIO);
                if (paddle.getVy() > Paddle.DEFAULT_SPEED / RATIO) {
                    final double before = paddle.getVy();
                    paddle.setVy(paddle.getVy() - Paddle.DEFAULT_SPEED / RATIO);
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

        //        public double getSignum() {
        //            return signum;
        //        }
        //
        //        public void setSignum(final double signum) {
        //            this.signum = signum;
        //        }

    }

}
