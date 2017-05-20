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

        frame = new DebugFrame();

    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        final Paddle left = model.getLeftPaddle();
        final Paddle right = model.getRightPaddle();
        final Ball ball = model.getBall();
        frame.yLeft.setState(left.isCollidingWithBallHorizontallyY(ball));

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

}
