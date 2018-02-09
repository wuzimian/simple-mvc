package org.wzm.simple.mvc.model;

import org.wzm.simple.mvc.Model;

import java.util.HashMap;
import java.util.Map;

public class DefaultModel implements Model {
    private Map<String,Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public Map<String, Object> getModelMap() {
        return data;
    }

    @Override
    public void addAttribute(String key, Object value) {
        data.put(key, value);
    }
}
