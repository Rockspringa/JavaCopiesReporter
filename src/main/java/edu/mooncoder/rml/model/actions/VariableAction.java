package edu.mooncoder.rml.model.actions;

import edu.mooncoder.rml.controllers.builders.SymbolsTable;
import edu.mooncoder.rml.model.contracts.Action;

public record VariableAction(String name, int line, int column) implements Action {
    @Override
    public Object get() {
        return SymbolsTable.getInst().get(name(), line(), column());
    }

    @Override
    public String getTagName() {
        return "Variable";
    }

    @Override
    public String getHtmlString() {
        return get().toString();
    }
}
