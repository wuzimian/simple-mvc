package org.wzm.simple.mvc;

import java.util.Map;

public interface Model {
    Map<String,Object> getModelMap();

    void addAttribute(String key, Object value);
}
