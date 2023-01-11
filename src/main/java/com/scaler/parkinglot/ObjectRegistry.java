package com.scaler.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectRegistry {

    private Map<String, Object> objects = new HashMap<>();

    public void register(String name, Object object) {
        objects.put(name, object);
    }

    public Object get(String name) {
        return objects.get(name);
    }
}
