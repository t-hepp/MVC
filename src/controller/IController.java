package controller;

public interface IController {

	public void start();

	public void pause();

	public void setLeftV(double v);

	public void setRightV(double v);

	public void leftWin();

	public void rightWin();

}
