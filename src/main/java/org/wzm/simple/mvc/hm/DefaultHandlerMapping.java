package org.wzm.simple.mvc.hm;

import org.wzm.simple.mvc.HandlerExecutionChain;
import org.wzm.simple.mvc.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class DefaultHandlerMapping implements HandlerMapping {
    private Map<String,HandlerMethod> handlerMapping = new HashMap<>();

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) {
        HandlerExecutionChain hec = new HandlerExecutionChain();
        String requestUri = request.getRequestURI();
        hec.setHandler(handlerMapping.get(requestUri));
        return hec;
    }

    @Override
    public void addHandlerMethod(String path, HandlerMethod handlerMethod) {
        handlerMapping.put(path, handlerMethod);
    }
}
