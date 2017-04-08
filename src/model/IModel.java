package model;

import java.util.Observer;

public interface IModel {

	public void start();

	public Ball getBall();

	public Paddle getLeftPaddle();

	public Paddle getRightPaddle();

	public Score getScore();

	public void leftWin();

	public void rightWin();

	public void resetScore();

	public void resetPostitons();

	public void addObserver(Observer o);

}
