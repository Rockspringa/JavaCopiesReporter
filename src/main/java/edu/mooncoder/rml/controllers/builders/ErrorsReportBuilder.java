package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.rml.exceptions.AnalysisException;
import edu.mooncoder.rml.model.tags.Error;

import java.util.ArrayList;
import java.util.List;

public class ErrorsReportBuilder {
    private static ErrorsReportBuilder inst;

    private final List<Error> errorsBattery = new ArrayList<>();

    public static void add(AnalysisException exception) {
        if (inst == null) {
            inst = new ErrorsReportBuilder();
        }
        inst.addError(exception);
    }

    public static Error[] close() {
        if (inst == null) {
            return new Error[0];
        }
        Error[] errors = inst.errorsBattery.toArray(new Error[0]);
        inst = null;
        return errors;
    }

    public void addError(AnalysisException exception) {
        String message = exception.getMessage();
        int line = exception.getLine();
        int column = exception.getColumn();
        String type = exception.is();

        errorsBattery.add(new Error(message, line, column, type));
    }
}
