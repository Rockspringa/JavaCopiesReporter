package edu.mooncoder.exceptions;

import edu.mooncoder.osrn.services.OsrnFactory;

import java.util.List;

public class AnalysisFailedException extends Exception {
    private final List<?> errors;

    public AnalysisFailedException(List<?> errors) {
        super("Surgieron errores en el analisis.");
        this.errors = errors;
    }

    public Object[] getErrors() {
        return OsrnFactory.getOsrnListByList(errors);
    }
}
