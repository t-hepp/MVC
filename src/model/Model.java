package model;

import java.util.Observable;

import model.Paddle.PaddleType;

public class Model extends Observable implements IModel {

    private final int refreshRate = 10;

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Score score;

    private Thread cc;

    private Thread notifier = null;

    public Model() {
        ball = new Ball();
        leftPaddle = new Paddle(PaddleType.LEFT);
        rightPaddle = new Paddle(PaddleType.RIGHT);
        initCollisionCheckers();
        score = new Score();
    }

    private void initCollisionCheckers() {

        cc = new Thread(new CollisionChecker(this));
        cc.start();

    }

    @Override
    public void restart() {
        ball.restart();

    }

    @Override
    public void init() {
        if (notifier == null) {
            notifier = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        collide();
                        move();
                        setChanged();
                        notifyObservers();
                        cc.interrupt();
                        try {
                            Thread.sleep(refreshRate);
                        }
                        catch (final Exception ex) {}
                    }
                }
            });

            notifier.start();
        }

    }

    @Override
    public Ball getBall() {
        return ball;
    }

    @Override
    public Paddle getLeftPaddle() {
        return leftPaddle;
    }

    @Override
    public Paddle getRightPaddle() {
        return rightPaddle;
    }

    @Override
    public Score getScore() {
        return score;
    }

    @Override
    public void leftWin() {
        resetPostitons();
        score.setLeft(score.getLeft() + 1);
        setChanged();
        notifyObservers(score);
    }

    @Override
    public void rightWin() {
        resetPostitons();
        score.setRight(score.getRight() + 1);
        setChanged();
        notifyObservers(score);
    }

    @Override
    public void resetScore() {
        score = new Score();
        setChanged();
        notifyObservers(score);
    }

    @Override
    public void resetPostitons() {
        ball.reset();

    }

    private void collide() {
        leftPaddle.verticalCollision();
        rightPaddle.verticalCollision();
        ball.verticalCollision();
        if (ball.isLeft()) {
            rightWin();
        }
        if (ball.isRight()) {
            leftWin();
        }
    }

    private void move() {
        ball.move();
        leftPaddle.move();
        rightPaddle.move();
    }

    @Override
    public int getRefreshRate() {
        return refreshRate;
    }

}
