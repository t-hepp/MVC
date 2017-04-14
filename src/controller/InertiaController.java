package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import model.IModel;
import model.Paddle;

public class InertiaController extends AbstractController {

    private InertiaEffect leftUp = new InertiaEffect(getLeft(), 0);
    private InertiaEffect leftDown = new InertiaEffect(getLeft(), 0);
    private InertiaEffect rightUp = new InertiaEffect(getRight(), 0);
    private InertiaEffect rightDown = new InertiaEffect(getRight(), 0);

    public InertiaController(final IModel model) {
        super(model);
        new Thread(rightUp).start();
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
        // TODO Auto-generated method stub

    }

    @Override
    public void leftUpReleased() {
        // TODO Auto-generated method stub

    }

    @Override
    public void leftDownPressed() {
        // TODO Auto-generated method stub

    }

    @Override
    public void leftDownReleased() {
        // TODO Auto-generated method stub

    }

    @Override
    public void rightUpPressed() {
        rightUp.setDirection(-1);

    }

    @Override
    public void rightUpReleased() {
        rightUp.setDirection(1);

    }

    @Override
    public void rightDownPressed() {
        rightDown.setDirection(1);

    }

    @Override
    public void rightDownReleased() {
        rightDown.setDirection(-1);

    }

    private class InertiaEffect implements Runnable {

        private final Paddle paddle;
        private double signum;
        private int direction;

        public InertiaEffect(final Paddle paddle, final int direction) {
            this.paddle = paddle;
            if (Math.signum(paddle.getVy()) != 0) {
                setSignum(Math.signum(paddle.getVy()));
            }
            else {
                setSignum(direction);
            }
            this.direction = direction;
        }

        @Override
        public void run() {
            while (true) {
                paddle.setVy(paddle.getVy() + direction * Paddle.DEFAULT_SPEED / 100);
                if (paddle.getVy() > direction * Paddle.DEFAULT_SPEED / 90) {
                    direction = 0;
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
            System.out.println(direction);
        }

        public double getSignum() {
            return signum;
        }

        public void setSignum(final double signum) {
            this.signum = signum;
        }

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
