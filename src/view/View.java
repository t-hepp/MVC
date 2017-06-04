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
import controller.bot.AbstractBot;
import controller.bot.PongBot;
import model.IModel;
import model.Model;
import model.Score;

public class View implements IView, Observer {

    private IModel model;
    private IController controller;

    private PongFrame frame;

    private IView debugView = null;
    private AbstractBot bot = null;

    public View(final IModel model) {
        this.model = model;
        this.model.addObserver(this);

        //TODO debugging changes
        //        controller = new InertiaController(model, new GodBot());
        controller = new InertiaController(model, bot);

    }

    public View(final IModel model, final IView debug) {
        this(model);
        debugView = debug;
    }

    @Override
    public void createAndShowGUI() {
        frame = new PongFrame(model);
        //        debugView = new DebugView(model);
        registerEventListener(controller.getEventListener());
        registerMenuListener();
    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        if (arg0 instanceof Model && frame != null) {
            frame.getGamePanel().repaint();
        }
        if (arg1 instanceof Score && frame != null) {
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
                controller = new InertiaController(model, bot);
            }
            else if (controller instanceof InertiaController) {
                controller = new ConstantSpeedController(model, bot);
            }
            registerEventListener(controller.getEventListener());

        }
        if (o == 1 && debugView != null) {
            debugView.setVisible(!debugView.isVisible());
        }

    }

    @Override
    public void setVisible(final boolean visible) {
        frame.setVisible(visible);

    }

    @Override
    public boolean isVisible() {
        return frame.isVisible();
    }

}
