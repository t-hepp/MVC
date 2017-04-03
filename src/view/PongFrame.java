package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PongFrame extends JFrame {

	private GamePanel game;
	private ScorePanel score;

	public PongFrame() {
		super("Pong");

		this.game = new GamePanel();
		this.score = new ScorePanel();

		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		add(game, BorderLayout.CENTER);
		add(score, BorderLayout.SOUTH);
		setVisible(true);
	}

}
