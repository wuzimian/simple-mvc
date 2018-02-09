package org.wzm.simple.mvc.support;

import org.wzm.simple.ioc.context.DefaultApplicationContext;
import org.wzm.simple.mvc.WebApplicationContext;

import javax.servlet.ServletContext;

public class DefaultWebApplicationContext extends DefaultApplicationContext implements WebApplicationContext{
    private ServletContext servletContext;

    public DefaultWebApplicationContext(String basePackage, ServletContext sc) {
        super(basePackage);
        this.servletContext = sc;
    }

    @Override
    public ServletContext getServletContext() {
        return servletContext;
    }
}
