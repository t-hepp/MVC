package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.Ball;
import model.IModel;
import model.Paddle;

public class GamePanel extends JPanel {

	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;

	public GamePanel(IModel model) {
		super(true);
		setup(model);

	}

	private void setup(IModel model) {
		ball = model.getBall();
		leftPaddle = model.getLeftPaddle();
		rightPaddle = model.getRightPaddle();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		gg.setColor(Color.LIGHT_GRAY);
		gg.fillRect(0, 0, getWidth(), getHeight());

		paintBall(gg);
		paintPaddle(gg, leftPaddle);
		paintPaddle(gg, rightPaddle);

	}

	private void paintPaddle(Graphics2D gg, Paddle paddle) {
		gg.setColor(Color.BLACK);
		gg.fillRect(absX(paddle.getX()), absY(paddle.getY()), absX(paddle.getWidth()), absY(paddle.getHeight()));
	}

	private void paintBall(Graphics2D gg) {
		gg.setColor(Color.BLACK);
		gg.fillOval(absX(ball.getX()), absY(ball.getY()), absX(ball.getRadius() * 2), absX(ball.getRadius() * 2));
	}

	private int absX(double relX) {
		return (int) Math.round(relX * getWidth());
	}

	private int absY(double relY) {
		return (int) Math.round(relY * getHeight());
	}

}
