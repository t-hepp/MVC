package view;

import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import controller.IController;
import controller.InertiaController;
import controller.bot.GodBot;
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

        controller = new InertiaController(model, new GodBot());

    }

    public void createAndShowGUI() {
        frame = new PongFrame(model);
        model.init();
        registerEventListener(controller.getEventListener());
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

}
