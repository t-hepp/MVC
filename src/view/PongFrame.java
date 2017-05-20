package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.IModel;

public class PongFrame extends JFrame {

    private GamePanel game;
    private ScorePanel score;

    public PongFrame(final IModel model) {
        super("Pong");

        game = new GamePanel(model);
        score = new ScorePanel();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        add(game, BorderLayout.CENTER);
        add(score, BorderLayout.SOUTH);
        setVisible(true);

    }

    public GamePanel getGamePanel() {
        return game;
    }

    public ScorePanel getScorePanel() {
        return score;
    }

    public int showOptions() {
        final Object[] options = { "Switch Controller", "Show / Hide Debug View", "cancel" };
        final int n = JOptionPane.showOptionDialog(this, "", "Options", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
        return n;
    }

}
