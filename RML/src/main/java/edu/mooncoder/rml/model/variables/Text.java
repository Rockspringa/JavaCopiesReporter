package edu.mooncoder.rml.model.variables;

import edu.mooncoder.rml.model.contracts.Variable;

public record Text(String value) implements Variable {
    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getTagName() {
        return "String";
    }

    @Override
    public String getHtmlString() {
        return value;
    }
}
