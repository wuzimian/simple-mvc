package org.wzm.simple.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class App {
    public static void main(String[] args) {
        try {
            Enumeration<URL> urls =  Thread.currentThread().getContextClassLoader().getResources("");
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                System.out.println(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
