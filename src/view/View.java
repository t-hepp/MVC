package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import controller.ConstantSpeedController;
import controller.IController;
import controller.InertiaController;
import model.IModel;
import model.Model;
import model.Score;

public class View implements IView, Observer {

    private IModel model;
    private IController controller;

    private PongFrame frame;

    public View(final IModel model) {
        this.model = model;
        this.model.addObserver(this);

        //TODO debugging changes
        //        controller = new InertiaController(model, new GodBot());
        controller = new InertiaController(model);

    }

    public void createAndShowGUI() {
        frame = new PongFrame(model);
        model.init();
        registerEventListener(controller.getEventListener());
        registerMenuListener();
    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        if (arg0 instanceof Model) {
            frame.getGamePanel().repaint();
        }
        if (arg1 instanceof Score) {
            final Score score = (Score) arg1;
            frame.getScorePanel().setScore(score);
        }

    }

    private void registerEventListener(final EventListener eventListener) {
        switch (controller.getInputType()) {
            case KEY:
                frame.addKeyListener((KeyListener) eventListener);
                break;
            default:
                throw new IllegalArgumentException("The InputType \"" + controller.getInputType() + "\" is not defined for this view.");
        }

    }

    private void removeEventListener(final EventListener eventListener) {
        switch (controller.getInputType()) {
            case KEY:
                frame.removeKeyListener((KeyListener) eventListener);
                break;
            default:
                throw new IllegalArgumentException("The InputType \"" + controller.getInputType() + "\" is not defined for this view.");
        }
    }

    private void registerMenuListener() {
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    options(frame.showOptions());
                }
            }

        });
    }

    protected void options(final int o) {
        if (o == 0) {
            controller.dispose();
            removeEventListener(controller.getEventListener());
            if (controller instanceof ConstantSpeedController) {
                controller = new InertiaController(model);
            }
            else if (controller instanceof InertiaController) {
                controller = new ConstantSpeedController(model);
            }
            registerEventListener(controller.getEventListener());

        }

    }

}
