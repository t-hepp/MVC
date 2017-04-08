package view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import controller.ConstantSpeedController;
import controller.IController;
import model.IModel;
import model.Model;
import model.Score;

public class View implements IView, Observer {

	private IModel model;
	private IController controller;

	private PongFrame frame;

	public View(IModel model) {
		this.model = model;
		this.model.addObserver(this);

		controller = new ConstantSpeedController(model);
	}

	public void createAndShowGUI() {
		this.frame = new PongFrame(model);
		frame.addKeyListener(new PongKeyListener());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof Model) {
			frame.getGamePanel().repaint();
		}
		if (arg1 instanceof Score) {
			Score score = (Score) arg1;
			frame.getScorePanel().setScore(score);
		}

	}

	@Override
	public Component getComponent() {
		return frame;
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
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				controller.start();
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
