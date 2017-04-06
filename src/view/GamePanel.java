package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Ball;
import model.Paddle;

public class GamePanel extends JPanel implements ActionListener {

	private Ball ball;

	private Paddle leftPaddle;
	private Paddle rightPaddle;

	private boolean setup = false;

	public GamePanel() {
		super(true);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				if (!setup) {
					setup();
					setup = true;
				}

			}
		});

		new Timer(10, this).start();

	}

	private void setup() {
		ball = new Ball();
		// ball.setXAbs(getWidth() / 2 - ball.getRadius(), getWidth());
		// ball.setYAbs(getHeight() / 2 - ball.getRadius(), getHeight());

		// leftPaddle = new Paddle(0.02, 0.5 - ((double)
		// Paddle.DEFAULT_HEIGHT /
		// 2 / getHeight()));
		// rightPaddle = new Paddle(getWidth() - 10 - Paddle.DEFAULT_WIDTH,
		// getHeight() / 2 - Paddle.DEFAULT_HEIGHT / 2);
		System.out.println("!!!!!");
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int w = getWidth();
		int h = getHeight();
		// System.out.println(w);
		// System.out.println(h);

		gg.setColor(Color.LIGHT_GRAY);
		gg.fillRect(0, 0, getWidth(), getHeight());

		paintBall(gg);
		paintPaddle(gg, leftPaddle);

	}

	private void paintPaddle(Graphics2D gg, Paddle paddle) {
		gg.setColor(Color.BLACK);
		// gg.fillRect(paddle.getXAbs(getWidth()), paddle.getYAbs(getHeight()),
		// paddle.getWidth(), paddle.getHeight());

	}

	private void paintBall(Graphics2D gg) {
		gg.setColor(Color.BLACK);
		// gg.fillOval(ball.getXAbs(getWidth()), ball.getYAbs(getHeight()),
		// ball.getRadius() * 2, ball.getRadius() * 2);
		gg.fillOval(absX(ball.getX()), absY(ball.getY()), absX(ball.getRadius() * 2), absX(ball.getRadius() * 2));
		// ball.checkCollision(getWidth(), getHeight());
		// if (ball.getX() + 2 * ball.getRadius() > getWidth()) {
		// ball.setVx(ball.getVx() * -1);
		// }
		// System.out.println("x: " + posX(ball.getX()));
		ball.move();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// repaint();
	}

	private int absX(double relX) {
		return (int) Math.round(relX * getWidth());
	}

	private int absY(double relY) {
		return (int) Math.round(relY * getHeight());
	}

}
