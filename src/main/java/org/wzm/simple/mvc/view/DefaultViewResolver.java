package org.wzm.simple.mvc.view;

import org.wzm.simple.mvc.View;
import org.wzm.simple.mvc.ViewResolver;

public class DefaultViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName) {
        String url = "/WEB-INF/templates/" + viewName + ".jsp";
        return new DefaultView(url);
    }
}
