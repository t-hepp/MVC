package controller;

import java.util.EventListener;

public interface IController {

    EventListener getEventListener();

    InputType getInputType();

    void startModel();

    void restart();

    void stop();

    void leftUpPressed();

    void leftUpReleased();

    void leftDownPressed();

    void leftDownReleased();

    void rightUpPressed();

    void rightUpReleased();

    void rightDownPressed();

    void rightDownReleased();

    void dispose();

}
