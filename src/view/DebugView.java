package view;

import java.util.Observable;
import java.util.Observer;

import model.Ball;
import model.IModel;
import model.Paddle;

public class DebugView implements IView, Observer {

    private IModel model;

    private DebugFrame frame = null;

    private boolean isVisible = false;

    public DebugView(final IModel model) {
        this.model = model;
        this.model.addObserver(this);

    }

    @Override
    public void createAndShowGUI() {
        frame = new DebugFrame();

    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        if (frame != null) {
            final Paddle left = model.getLeftPaddle();
            final Paddle right = model.getRightPaddle();
            final Ball ball = model.getBall();
            frame.yLeft.setState(left.isCollidingWithBallHorizontallyY(ball));
        }

    }

    public void showHide() {
        if (isVisible) {
            isVisible = false;
            frame.setVisible(false);
        }
        else {
            isVisible = true;
            frame.setVisible(true);
        }
    }

    @Override
    public void setVisible(final boolean visible) {
        frame.setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return frame.isVisible();
    }

}
