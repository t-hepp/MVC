package model;

import java.util.Observable;

public class Model extends Observable implements IModel {

	private Ball ball;
	private Paddle leftPadle;
	private Paddle rightPaddle;
	private Score score;

	private Thread notifier = null;

	public Model() {
		this.ball = new Ball();
	}

	@Override
	public void start() {
		if (notifier == null) {
			notifier = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						move();
						setChanged();
						notifyObservers(score);
						try {
							Thread.sleep(10);
						} catch (Exception ex) {
						}
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
	public Paddle getLeftPadle() {
		return leftPadle;
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
		score.setLeft(score.getLeft() + 1);
		setChanged();
		notifyObservers(score);
	}

	@Override
	public void rightWin() {
		score.setRight(score.getRight() + 1);
		setChanged();
		notifyObservers(score);
	}

	@Override
	public void resetScore() {
		this.score = new Score();
		setChanged();
		notifyObservers(score);
	}

	@Override
	public void resetPostitons() {
		// TODO Auto-generated method stub

	}

	private void move() {
		ball.move();
		// leftPadle.move();
		// rightPaddle.move();
	}

}
