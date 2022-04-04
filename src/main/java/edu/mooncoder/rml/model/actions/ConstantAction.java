package edu.mooncoder.rml.model.actions;

import edu.mooncoder.rml.model.contracts.Action;

public record ConstantAction(Object value) implements Action {
    @Override
    public Object get() {
        return value;
    }

    @Override
    public String getTagName() {
        return "Constante";
    }

    @Override
    public String getHtmlString() {
        return value.toString();
    }
}
