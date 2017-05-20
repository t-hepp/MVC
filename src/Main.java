import javax.swing.SwingUtilities;

import model.IModel;
import model.Model;
import view.DebugView;
import view.IView;
import view.View;

public class Main {

    public static void main(final String[] args) {

        final IModel model = new Model();
        model.init();

        final IView debug = new DebugView(model);
        final IView view = new View(model, debug);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                debug.createAndShowGUI();
            }
        });

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                view.createAndShowGUI();
            }
        });

    }

}
