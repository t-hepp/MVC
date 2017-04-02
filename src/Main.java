import javax.swing.SwingUtilities;

import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

	public static void main(String[] args) {

		View view = new View(new Model(), new Controller());
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				view.createAndShowGUI();

			}
		});

	}

}