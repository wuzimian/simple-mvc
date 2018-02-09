package org.wzm.simple.mvc.ha;

import org.wzm.simple.mvc.HandlerMethod;
import org.wzm.simple.mvc.Model;
import org.wzm.simple.mvc.ModelAndView;
import org.wzm.simple.mvc.model.DefaultModel;

public class DefaultHandlerAdapter implements HandlerAdapter{
    @Override
    public ModelAndView handle(HandlerMethod handlerMethod) {
        ModelAndView mav = new ModelAndView();
        Model model = new DefaultModel();
        mav.setModel(model);
        Object result = handlerMethod.execute(model);
        mav.setView(result);
        return mav;
    }
}
