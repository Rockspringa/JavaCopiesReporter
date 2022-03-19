package edu.mooncoder.model.containers;

import edu.mooncoder.model.wrappers.Method;
import edu.mooncoder.model.wrappers.Variable;

import java.util.ArrayList;
import java.util.List;

public class MethodsHolder {
    private static MethodsHolder inst;
    private final List<Method> methods;

    private MethodsHolder() {
        methods = new ArrayList<>();
    }

    public static void addMethod(String name, String type, Variable... parameters) {
        if (inst == null) {
            inst = new MethodsHolder();
        }
        if (name != null)
            inst.add(name, type, parameters);
    }

    public static List<Method> clean() {
        if (inst == null) {
            inst = new MethodsHolder();
        }
        List<Method> methods = inst.methods;
        inst = null;
        return methods;
    }

    public void add(String name, String type, Variable... parameters) {
        methods.add(new Method(name, type, parameters));
    }
}
