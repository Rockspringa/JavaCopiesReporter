package edu.mooncoder.rml.model.accesors;

import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.semantical.IndexOutOfLimitsException;
import edu.mooncoder.rml.exceptions.semantical.NonePointerException;
import edu.mooncoder.rml.exceptions.semantical.TypeNotMatchException;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.ResultAccesor;

public record Array(Action var, ResultAccesor accessor, int line, int column) implements ResultAccesor {
    @Override
    public Object get(Object obj) {
        if (var.get() instanceof Integer index) {
            if (accessor() != null) {
                if (accessor().get(obj) instanceof Object[] arr) {
                    try {
                        return arr[index];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ErrorsReportBuilder.add(new IndexOutOfLimitsException(index, arr.length, line(), column()));
                    }
                } else {
                    ErrorsReportBuilder.add(new TypeNotMatchException(line(), column()));
                }
            } else {
                ErrorsReportBuilder.add(new NonePointerException(line(), column()));
            }
        }
        return null;
    }
}
