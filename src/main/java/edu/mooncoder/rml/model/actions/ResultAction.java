package edu.mooncoder.rml.model.actions;

import edu.mooncoder.rml.controllers.builders.SymbolsTable;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.ResultAccesor;

import java.util.Arrays;

public record ResultAction(ResultAccesor attr, int line, int column) implements Action {
    private static final String NAME = "RESULT";

    @Override
    public Object get() {
        Object obj = null;

        if (attr != null)
             obj = attr().get(SymbolsTable.getInst().get(NAME, line(), column()));
        else
            obj = SymbolsTable.getInst().get(NAME, line(), column());

        if (obj instanceof Object[] arr)
            return Arrays.toString(arr);
        return obj;
    }

    @Override
    public String getTagName() {
        return "RESULT";
    }

    @Override
    public String getHtmlString() {
        return get().toString();
    }
}
