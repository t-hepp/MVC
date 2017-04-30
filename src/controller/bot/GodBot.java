package controller.bot;

import controller.InertiaController;
import model.Paddle;

public class GodBot extends AbstractBot {

    @Override
    public void run() {
        while (true) {

            if (getBall().getVx() <= 0) {
                moveToCenter();
            }
            else {
                moveTo(calculatePos());
            }

            try {
                Thread.sleep(10);
            }
            catch (final Exception ex) {}
        }

    }

    private double calculatePos() {

        final double incline = getBall().getVy() / getBall().getVx();
        double pos = getBall().getCenterY() + incline * (getPaddle().getX() - (getBall().getX() + getBall().getRadius() * 2));
        System.out.println(pos);
        final double distance = pos % 1;
        if (((int) pos) % 2 != 0) {
            pos = 1 - distance;
        }
        else {
            pos = distance;
        }
        //        System.out.println(distance);
        return pos;
    }

    private void moveTo(final double pos) {
        final Paddle p = getPaddle();
        final double v = getPaddle().getVy();

        if (!(getController() instanceof InertiaController)) {
            if ((Math.abs(getPaddle().getCenterY() - pos) < getPaddle().getHeight() / 4) && getPaddle().getVy() > 0.00001) {
                getController().rightUpReleased();
                getController().rightDownReleased();
            }
            else {
                if (getPaddle().getCenterY() > pos) {
                    getController().rightDownReleased();
                    getController().rightUpPressed();
                }
                else {
                    getController().rightUpReleased();
                    getController().rightDownPressed();
                }
            }
        }
        else {
            //            final double t = Math.abs(v) / (120 * Paddle.DEFAULT_SPEED);

            if ((Math.abs(p.getCenterY() - pos) < p.getHeight() / 4) && v > 0.00001) {
                if (Math.signum(getPaddle().getVy()) == Math.signum(pos - getPaddle().getCenterY())) {
                    getController().rightUpReleased();
                    getController().rightDownReleased();
                }
            }
            else {
                if (getPaddle().getCenterY() > pos) {
                    getController().rightDownReleased();
                    getController().rightUpPressed();
                }
                else {
                    getController().rightUpReleased();
                    getController().rightDownPressed();
                }
            }
        }
    }

    private void moveToCenter() {
        moveTo(0.5);
    }

}
