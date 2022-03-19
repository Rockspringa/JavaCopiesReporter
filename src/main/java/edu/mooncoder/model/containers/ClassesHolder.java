package edu.mooncoder.model.containers;

import edu.mooncoder.model.wrappers.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassesHolder {
    private static ClassesHolder inst;
    private final List<Class> classNames;

    private ClassesHolder() {
        classNames = new ArrayList<>();
    }

    public static void addClass(String name) {
        if (inst == null) {
            inst = new ClassesHolder();
        }
        if (name != null)
            inst.add(name);
    }

    public static List<Class> clean() {
        if (inst == null) {
            inst = new ClassesHolder();
        }
        List<Class> classes = inst.classNames;
        inst = null;
        return classes;
    }

    public void add(String name) {
        classNames.add(new Class(name));
    }
}