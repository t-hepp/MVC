package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import model.IModel;
import model.Paddle;

public class InertiaController extends AbstractController {

    private InertiaEffect leftInertiaEffect = new InertiaEffect(getLeft(), 0);
    private InertiaEffect rightInertiaEffect = new InertiaEffect(getRight(), 0);

    public InertiaController(final IModel model) {
        super(model);
        new Thread(rightInertiaEffect).start();
        new Thread(leftInertiaEffect).start();
    }

    @Override
    public EventListener getEventListener() {
        return new PongKeyListener();
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
                    System.out.println("dif " + (before - after * 1000000));
                    System.out.println("down inertia " + (-Paddle.DEFAULT_SPEED / RATIO));
                }
                else if (paddle.getVy() < -Paddle.DEFAULT_SPEED / RATIO) {
                    final double before = paddle.getVy();
                    paddle.setVy(paddle.getVy() + Paddle.DEFAULT_SPEED / RATIO);
                    final double after = paddle.getVy();
                    System.out.println("dif " + (before - after * 1000000));
                    System.out.println("up inertia " + (Paddle.DEFAULT_SPEED / RATIO));
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

    /**
     * ...and the night will connect their thoughts.
     *
     * @author Thomas
     *
     */
    private class PongKeyListener implements KeyListener {

        @Override
        public void keyPressed(final KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    leftUpPressed();
                    break;
                case KeyEvent.VK_S:
                    leftDownPressed();
                    break;
                case KeyEvent.VK_UP:
                    rightUpPressed();
                    break;
                case KeyEvent.VK_DOWN:
                    rightDownPressed();
                    break;
                default:
                    break;
            }

        }

        @Override
        public void keyReleased(final KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    restart();
                    break;
                case KeyEvent.VK_W:
                    leftUpReleased();
                    break;
                case KeyEvent.VK_S:
                    leftDownReleased();
                    break;
                case KeyEvent.VK_UP:
                    rightUpReleased();
                    break;
                case KeyEvent.VK_DOWN:
                    rightDownReleased();
                    break;
                default:
                    break;
            }

        }

        @Override
        public void keyTyped(final KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }
}
