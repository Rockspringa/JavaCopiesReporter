package edu.mooncoder.rml.model.accesors;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.semantical.TypeNotMatchException;
import edu.mooncoder.rml.model.contracts.ResultAccesor;

public record Attribute(String name, ResultAccesor accessor, int line, int column) implements ResultAccesor {
    @Override
    public Object get(Object obj) {
        if (obj instanceof Osrn osrn) {
            if (accessor() != null) {
                if (accessor().get(osrn) instanceof Osrn resOsrn) {
                    return resOsrn.getValue(name());
                }
            } else {
                return osrn.getValue(name());
            }
        }
        ErrorsReportBuilder.add(new TypeNotMatchException(line(), column()));
        return null;
    }
}
