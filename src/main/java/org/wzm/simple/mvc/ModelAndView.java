package org.wzm.simple.mvc;

public class ModelAndView {
    private Model model;
    private Object view;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }
}
