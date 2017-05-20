package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DebugFrame extends JFrame {

    private final Font inactive = new Font("Calibri", Font.PLAIN, 14);
    private final Font active = new Font("Calibri", Font.BOLD, 15);

    public DebugLabel yLeft;
    public DebugLabel yRight;

    public DebugFrame() {
        super("DebugView");
        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        yLeft = new DebugLabel("yCollisionRangeLeft");
        yLeft.setFont(inactive);
        yLeft.setBounds(32, 25, 148, 36);
        getContentPane().add(yLeft);

        yRight = new DebugLabel("yCollisionRangeRight");
        yRight.setFont(inactive);
        yRight.setBounds(235, 25, 148, 36);
        getContentPane().add(yRight);

        setVisible(false);

    }

    class DebugLabel extends JLabel {

        public DebugLabel(final String string) {
            super(string);
        }

        public void setState(final boolean state) {
            if (state) {
                setFont(active);
                setForeground(Color.RED);
            }
            else {
                setFont(inactive);
                setForeground(Color.BLUE);
            }
        }

    }
}
