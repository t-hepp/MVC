package model;

import java.util.Observable;

public class Model extends Observable {

	private Ball ball;
	private Paddle leftPadle;
	private Paddle rightPaddle;
	private Score score;

	public Ball getBall() {
		return ball;
	}

	public Paddle getLeftPadle() {
		return leftPadle;
	}

	public Paddle getRightPaddle() {
		return rightPaddle;
	}

	public Score getScore() {
		return score;
	}

	public void leftWin() {
		score.setLeft(score.getLeft() + 1);
		setChanged();
		notifyObservers(score);
	}

	public void rightWin() {
		score.setRight(score.getRight() + 1);
		setChanged();
		notifyObservers(score);
	}

	public void resetScore() {
		this.score = new Score();
		setChanged();
		notifyObservers(score);
	}

}
