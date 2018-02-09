package org.wzm.simple.mvc.hm;

import org.wzm.simple.mvc.HandlerExecutionChain;
import org.wzm.simple.mvc.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

public interface HandlerMapping {
    HandlerExecutionChain getHandler(HttpServletRequest request);

    void addHandlerMethod(String path, HandlerMethod handlerMethod);
}
