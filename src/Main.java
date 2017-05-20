import javax.swing.SwingUtilities;

import model.Model;
import view.View;

public class Main {

    public static void main(final String[] args) {

        final View view = new View(new Model());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                view.createAndShowGUI();

            }
        });

    }

}
