package org.wzm.simple.mvc;

import org.wzm.simple.mvc.hi.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;

public class HandlerExecutionChain {
    private List<HandlerInterceptor> interceptorList = new ArrayList<>();
    private HandlerMethod handler;

    public List<HandlerInterceptor> getInterceptorList() {
        return interceptorList;
    }

    public void setInterceptorList(List<HandlerInterceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public HandlerMethod getHandler() {
        return handler;
    }

    public void setHandler(HandlerMethod handler) {
        this.handler = handler;
    }
}
