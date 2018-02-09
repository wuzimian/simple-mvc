package org.wzm.simple.mvc;

import org.wzm.simple.ioc.definition.BeanDefinition;
import org.wzm.simple.ioc.factory.BeanFactory;
import org.wzm.simple.mvc.annotation.Controller;
import org.wzm.simple.mvc.annotation.RequestMapping;
import org.wzm.simple.mvc.ha.DefaultHandlerAdapter;
import org.wzm.simple.mvc.ha.HandlerAdapter;
import org.wzm.simple.mvc.hm.DefaultHandlerMapping;
import org.wzm.simple.mvc.hm.HandlerMapping;
import org.wzm.simple.mvc.view.DefaultViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns ={"/"} , loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private HandlerAdapter handlerAdapter;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        super.init();
        initStrategies();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp){
        HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(req);
        ModelAndView modelAndView = handlerAdapter.handle(handlerExecutionChain.getHandler());
        Object view = modelAndView.getView();
        if(view instanceof String) {
            View realView = viewResolver.resolveViewName((String)view);
            realView.render(modelAndView.getModel().getModelMap(), req, resp);
        }

    }

    private void initStrategies(){
        ServletContext sc = getServletContext();
        WebApplicationContext wac = (WebApplicationContext) sc.getAttribute(Constants.ROOT_CONTEXT);
        initHandlerMapping(wac);
        initHandlerAdapter(wac);
        initViewResolver(wac);
    }

    private void initHandlerMapping(WebApplicationContext wac){
        if(handlerMapping == null) {
            handlerMapping = new DefaultHandlerMapping();
        }

        BeanFactory beanFactory = wac.getBeanFactory();
        Map<String,BeanDefinition> beanDefinitionMap =  beanFactory.getBeanDefinitionMap();
        beanDefinitionMap.forEach((beanName, beanDef) -> {
            Class<?> beanClass = beanDef.getBeanClazz();
            if(beanClass.isAnnotationPresent(Controller.class)){
                Method [] methods = beanClass.getDeclaredMethods();
                for(Method method : methods) {
                    if(method.isAnnotationPresent(RequestMapping.class)){
                        String path = method.getAnnotation(RequestMapping.class).path();
                        handlerMapping.addHandlerMethod(path, new HandlerMethod(beanFactory.getBean(beanName),method));
                    }
                }
            }
        });
    }

    private void initHandlerAdapter(WebApplicationContext wac){
        if(handlerAdapter == null) {
            handlerAdapter = new DefaultHandlerAdapter();
        }
    }

    private void initViewResolver(WebApplicationContext wac){
        if(viewResolver == null) {
            viewResolver = new DefaultViewResolver();
        }
    }
}
