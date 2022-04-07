package edu.mooncoder.model.wrappers;

import edu.mooncoder.model.types.ErrorType;

import java.io.Serializable;

public record Error(ErrorType type, String filename, int project, int line, int column, String message) implements Serializable {
    public Object[] getArrayData() {
        return new Object[]{project(), filename(), "", line(), column(), type(), message()};
    }
}
