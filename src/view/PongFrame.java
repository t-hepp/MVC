package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {

				}

			}
		});
	}

	public GamePanel getGamePanel() {
		return game;
	}

	public ScorePanel getScorePanel() {
		return score;
	}

}
