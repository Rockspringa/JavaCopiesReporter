package edu.mooncoder.rml.model.variables;

import edu.mooncoder.rml.model.contracts.Variable;

public record Int(int value) implements Variable {
    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getTagName() {
        return "Integer";
    }

    @Override
    public String getHtmlString() {
        return String.valueOf(value);
    }
}
