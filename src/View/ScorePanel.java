package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	private JLabel leftLabel;
	private JLabel rightLabel;

	public ScorePanel() {

		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		leftLabel = new JLabel("0");
		JLabel separator = new JLabel(":");
		rightLabel = new JLabel("0");

		separator.setHorizontalAlignment(0);

		leftLabel.setFont(new Font("Arial", Font.BOLD, 30));
		separator.setFont(new Font("Arial", Font.BOLD, 30));
		rightLabel.setFont(new Font("Arial", Font.BOLD, 30));

		add(leftLabel, BorderLayout.WEST);
		add(separator, BorderLayout.CENTER);
		add(rightLabel, BorderLayout.EAST);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

			}
		});

	}

	public void setLeftScore(int left) {
		leftLabel.setText(String.valueOf(left));
	}

	public void setRight(int right) {
		rightLabel.setText(String.valueOf(right));
	}

}
