package org.wzm.simple.mvc;

import org.wzm.simple.mvc.support.DefaultWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        WebApplicationContext wac = new DefaultWebApplicationContext("/", sc);
        sc.setAttribute(Constants.ROOT_CONTEXT, wac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
