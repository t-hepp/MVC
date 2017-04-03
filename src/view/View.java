package view;

import java.util.Observable;
import java.util.Observer;

import controller.Controller;
import model.Model;

public class View implements Observer {

	private Model model;
	private Controller controller;

	private PongFrame frame;

	public View(Model model, Controller controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}

	public void createAndShowGUI() {
		this.frame = new PongFrame();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
