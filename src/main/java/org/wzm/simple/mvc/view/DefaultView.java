package org.wzm.simple.mvc.view;

import org.wzm.simple.mvc.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DefaultView implements View {
    private String url;

    public DefaultView(String url) {
        this.url = url;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) {
        exposeModelAsRequestAttributes(model, request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void exposeModelAsRequestAttributes(Map<String, ?> model, HttpServletRequest request) {

        model.forEach((modelName, modelValue) -> {
                request.setAttribute(modelName, modelValue);
        });


    }
}
