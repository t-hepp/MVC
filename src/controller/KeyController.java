package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IModel;
import view.IView;

public class KeyController implements IController {

	IModel model;

	@Override
	public void addListener(IView view) {
		view.getComponent().addKeyListener(new KeyControllerListener());

	}

	@Override
	public void setModel(IModel model) {
		this.model = model;

	}

	private class KeyControllerListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				model.start();
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
