package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DebugFrame extends JFrame {

    private final Font inactive = new Font("Calibri", Font.PLAIN, 18);
    private final Font active = new Font("Calibri", Font.BOLD, 20);

    public DebugLabel yLeft;
    public DebugLabel yRight;
    public DebugLabel xLeft;
    public DebugLabel xRight;
    public DebugLabel ballC;
    public DebugLabel ballS;
    public DebugLabel ballSX;
    public DebugLabel ballSY;
    public DebugLabel leftS;
    public DebugLabel rightS;

    public DebugFrame() {
        super("DebugView");
        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 500);

        yLeft = new DebugLabel("yCollisionRangeLeft");
        yLeft.setFont(inactive);
        yLeft.setBounds(32, 25, 178, 36);
        getContentPane().add(yLeft);

        yRight = new DebugLabel("yCollisionRangeRight");
        yRight.setFont(inactive);
        yRight.setBounds(250, 25, 178, 36);
        getContentPane().add(yRight);

        xLeft = new DebugLabel("xCollisionRangeLeft");
        xLeft.setFont(inactive);
        xLeft.setBounds(32, 111, 178, 36);
        getContentPane().add(xLeft);

        xRight = new DebugLabel("xCollisionRangeRight");
        xRight.setFont(inactive);
        xRight.setBounds(250, 111, 178, 36);
        getContentPane().add(xRight);

        ballC = new DebugLabel("Ball Coordinates:  ");
        ballC.setDefaultText("Ball Coordinates:  ");
        ballC.setFont(inactive);
        ballC.setBounds(32, 201, 210, 36);
        getContentPane().add(ballC);

        ballS = new DebugLabel("Ball Speed:  ");
        ballS.setDefaultText("Ball Speed:  ");
        ballS.setFont(inactive);
        ballS.setBounds(250, 201, 178, 36);
        getContentPane().add(ballS);

        ballSX = new DebugLabel("Ball Speed x:  ");
        ballSX.setDefaultText("Ball Speed x:  ");
        ballSX.setFont(inactive);
        ballSX.setBounds(32, 289, 178, 36);
        getContentPane().add(ballSX);

        ballSY = new DebugLabel("Ball Speed y:  ");
        ballSY.setDefaultText("Ball Speed y:  ");
        ballSY.setFont(inactive);
        ballSY.setBounds(250, 289, 178, 36);
        getContentPane().add(ballSY);

        leftS = new DebugLabel("left P Speed:  ");
        leftS.setDefaultText("left P Speed:  ");
        leftS.setFont(inactive);
        leftS.setBounds(32, 380, 178, 36);
        getContentPane().add(leftS);

        rightS = new DebugLabel("right P Speed:  ");
        rightS.setDefaultText("right P Speed:  ");
        rightS.setFont(inactive);
        rightS.setBounds(250, 380, 178, 36);
        getContentPane().add(rightS);

        setVisible(true);

    }

    class DebugLabel extends JLabel {

        private String defaultText = "";

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
                setForeground(Color.BLACK);
            }
        }

        public String getDefaultText() {
            return defaultText;
        }

        public void setDefaultText(final String defaultText) {
            this.defaultText = defaultText;
        }

    }
}
