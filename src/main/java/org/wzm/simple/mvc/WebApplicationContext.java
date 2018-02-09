package org.wzm.simple.mvc;

import org.wzm.simple.ioc.context.ApplicationContext;

import javax.servlet.ServletContext;

public interface WebApplicationContext extends ApplicationContext {
    ServletContext getServletContext();
}
