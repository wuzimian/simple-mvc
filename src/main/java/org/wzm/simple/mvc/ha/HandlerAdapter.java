package org.wzm.simple.mvc.ha;

import org.wzm.simple.mvc.HandlerMethod;
import org.wzm.simple.mvc.ModelAndView;

public interface HandlerAdapter {
    ModelAndView handle(HandlerMethod handlerMethod);
}
