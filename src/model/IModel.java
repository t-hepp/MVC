package model;

public interface IModel {

	public Ball getBall();

	public Paddle getLeftPadle();

	public Paddle getRightPaddle();

	public Score getScore();

	public void leftWin();

	public void rightWin();

	public void resetScore();

	public void resetPostitons();

}
