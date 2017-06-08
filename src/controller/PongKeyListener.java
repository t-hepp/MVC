package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongKeyListener implements KeyListener {

    private IController controller;

    public PongKeyListener(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                controller.leftUpPressed();
                break;
            case KeyEvent.VK_S:
                controller.leftDownPressed();
                break;
            case KeyEvent.VK_UP:
                controller.rightUpPressed();
                break;
            case KeyEvent.VK_DOWN:
                controller.rightDownPressed();
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                controller.restart();
                break;
            case KeyEvent.VK_W:
                controller.leftUpReleased();
                break;
            case KeyEvent.VK_S:
                controller.leftDownReleased();
                break;
            case KeyEvent.VK_UP:
                controller.rightUpReleased();
                break;
            case KeyEvent.VK_DOWN:
                controller.rightDownReleased();
                break;
            default:
                break;
        }

    }

    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
