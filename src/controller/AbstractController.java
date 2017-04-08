package controller;

import model.IModel;

public abstract class AbstractController implements IController {

	private final IModel model;

	public AbstractController(IModel model) {
		this.model = model;
	}

	@Override
	public void start() {
		model.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public abstract void leftUpPressed();

	@Override
	public abstract void leftUpReleased();

	@Override
	public abstract void leftDownPressed();

	@Override
	public abstract void leftDownReleased();

	@Override
	public abstract void rightUpPressed();

	@Override
	public abstract void rightUpReleased();

	@Override
	public abstract void rightDownPressed();

	@Override
	public abstract void rightDownReleased();

}
