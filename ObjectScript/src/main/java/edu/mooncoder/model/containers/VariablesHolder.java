package edu.mooncoder.model.containers;

import edu.mooncoder.model.wrappers.Variable;

import java.util.ArrayList;
import java.util.List;

public class VariablesHolder {
    private static VariablesHolder inst;
    private final List<Variable> variables;

    private VariablesHolder() {
        variables = new ArrayList<>();
    }

    public static void addVariable(Variable var) {
        if (inst == null) {
            inst = new VariablesHolder();
        }
        if (var.getName() != null)
            inst.add(var);
    }

    public static List<Variable> clean() {
        if (inst == null) {
            inst = new VariablesHolder();
        }
        List<Variable> variables = inst.variables;
        inst = null;
        return variables;
    }

    public void add(Variable var) {
        variables.add(var);
    }
}
