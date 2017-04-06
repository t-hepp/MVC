package controller;

import model.IModel;
import view.IView;

public interface IController {

	void addListener(IView view);

	void setModel(IModel model);

}
