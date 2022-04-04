package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.rml.exceptions.semantical.TypeNotMatchException;
import edu.mooncoder.rml.model.accesors.Array;
import edu.mooncoder.rml.model.accesors.Attribute;
import edu.mooncoder.rml.model.actions.ConstantAction;
import edu.mooncoder.rml.model.actions.ResultAction;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.ResultAccesor;

public class ResultBuilder {
    private static ResultBuilder inst;

    private ResultAccesor accessor;

    private ResultBuilder() {
    }

    public static void initAnalysis() {
        inst = null;
    }

    public static ResultBuilder getInst() {
        if (inst == null) inst = new ResultBuilder();
        return inst;
    }

    public void add(String name, int line, int column) {
        if (inst == null) {
            inst = new ResultBuilder();
        }
        if (name != null) inst.setAction(name, line, column);
        else ErrorsReportBuilder.add(new TypeNotMatchException(line, column));
    }

    public void add(String name, Object number, int line, int column) {
        if (inst == null) {
            inst = new ResultBuilder();
        }
        if (number instanceof Integer value) {
            inst.setAction(name, value, line, column);
            return;
        } else if (number instanceof Action action) {
            if (action.get() instanceof Integer) {
                inst.setAction(name, action, line, column);
                return;
            }
        }
        ErrorsReportBuilder.add(new TypeNotMatchException(line, column));
    }

    public ResultAction getResult(int line, int column) {
        ResultAction action = new ResultAction(accessor, line, column);
        accessor = null;
        return action;
    }

    private void setAction(String name, int line, int column) {
        accessor = new Attribute(name, accessor, line, column);
    }

    private void setAction(String name, int value, int line, int column) {
        setAction(name, line, column);
        accessor = new Array(new ConstantAction(value), accessor, line + name.length(), column);
    }

    private void setAction(String name, Action value, int line, int column) {
        setAction(name, line, column);
        accessor = new Array(value, accessor, line + name.length(), column);
    }
}
