package controller;

import model.IModel;
import model.Paddle;

public class ConstantSpeedController extends AbstractController {

	public ConstantSpeedController(IModel model) {
		super(model);
	}

	@Override
	public void leftUpPressed() {
		getLeft().setVy(-Paddle.DEFAULT_SPEED);
	}

	@Override
	public void leftUpReleased() {
		getLeft().setVy(0);
	}

	@Override
	public void leftDownPressed() {
		getLeft().setVy(Paddle.DEFAULT_SPEED);
	}

	@Override
	public void leftDownReleased() {
		getLeft().setVy(0);
	}

	@Override
	public void rightUpPressed() {
		getRight().setVy(-Paddle.DEFAULT_SPEED);
	}

	@Override
	public void rightUpReleased() {
		getRight().setVy(0);
	}

	@Override
	public void rightDownPressed() {
		getRight().setVy(Paddle.DEFAULT_SPEED);
	}

	@Override
	public void rightDownReleased() {
		getRight().setVy(0);

	}

}
