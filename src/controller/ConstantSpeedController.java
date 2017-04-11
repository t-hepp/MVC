package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import model.IModel;
import model.Paddle;

public class ConstantSpeedController extends AbstractController {

	public ConstantSpeedController(IModel model) {
		super(model);
	}

	@Override
	public EventListener getEventListener() {
		return new PongKeyListener();
	}

	@Override
	public InputType getInputType() {
		return InputType.KEY;
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

	/**
	 * ...and the night will connect their thoughts.
	 * 
	 * @author Thomas
	 *
	 */
	private class PongKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				leftUpPressed();
				break;
			case KeyEvent.VK_S:
				leftDownPressed();
				break;
			case KeyEvent.VK_UP:
				rightUpPressed();
				break;
			case KeyEvent.VK_DOWN:
				rightDownPressed();
				break;
			default:
				break;
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				restart();
				break;
			case KeyEvent.VK_W:
				leftUpReleased();
				break;
			case KeyEvent.VK_S:
				leftDownReleased();
				break;
			case KeyEvent.VK_UP:
				rightUpReleased();
				break;
			case KeyEvent.VK_DOWN:
				rightDownReleased();
				break;
			default:
				break;
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
