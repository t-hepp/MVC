package view;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import controller.IController;
import controller.KeyController;
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

		controller = new KeyController();
		controller.setModel(model);
	}

	public void createAndShowGUI() {
		this.frame = new PongFrame();
		controller.addListener(this);
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

}
