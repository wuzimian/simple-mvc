package org.wzm.simple.mvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandlerMethod {
    private final Object bean;
    private final Method method;

    public HandlerMethod(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    public Object execute(Model model){
        try {
            return method.invoke(bean,model);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
