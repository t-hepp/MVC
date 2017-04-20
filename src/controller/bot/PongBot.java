package controller.bot;

public class PongBot extends AbstractBot {

    @Override
    public void run() {

        while (true) {

            if (Math.abs(getBall().getCenterY() - (getPaddle().getY() + getPaddle().getHeight() / 2)) < getPaddle().getHeight() / 4) {
                getController().rightUpReleased();
                getController().rightDownReleased();
            }
            else {
                if (getBall().getCenterY() > getPaddle().getY() + getPaddle().getHeight() / 2) {
                    getController().rightUpReleased();
                    getController().rightDownPressed();
                }
                else {
                    getController().rightDownReleased();
                    getController().rightUpPressed();
                }
            }
            try {
                Thread.sleep(10);
            }
            catch (final Exception ex) {}
        }
    }
}
