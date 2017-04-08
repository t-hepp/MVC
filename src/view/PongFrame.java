package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.IModel;

public class PongFrame extends JFrame {

	private GamePanel game;
	private ScorePanel score;

	public PongFrame(IModel model) {
		super("Pong");

		this.game = new GamePanel(model);
		this.score = new ScorePanel();

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

}
