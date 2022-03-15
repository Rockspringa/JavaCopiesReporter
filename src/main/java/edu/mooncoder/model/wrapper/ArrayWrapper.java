package edu.mooncoder.model.wrapper;

import edu.mooncoder.model.containers.Osrn;

import java.util.ArrayList;
import java.util.List;

public class ArrayWrapper {
    private static final List<ArrayWrapper> instances = new ArrayList<>();
    private static int level = -1;
    private final List<Object> list;

    private ArrayWrapper() {
        list = new ArrayList<>();
    }

    public static void addFirst(Object value) {
        instances.add(new ArrayWrapper());
        level++;
        add(value);
    }

    public static void addEmpty() {
        instances.add(new ArrayWrapper());
        level++;
    }

    public static void add(Object value) {
        instances.get(level).list.add(value);
    }

    public static Object[] close() {
        Object[] list = instances.get(level).list.toArray(new Object[0]);
        instances.remove(level--);
        return list;
    }
}
