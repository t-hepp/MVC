package model;

import java.util.Observable;

public class Model extends Observable implements IModel {

	private Ball ball;
	private Paddle leftPadle;
	private Paddle rightPaddle;
	private Score score;

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

}
