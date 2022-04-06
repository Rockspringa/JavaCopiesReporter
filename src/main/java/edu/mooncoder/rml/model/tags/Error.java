package edu.mooncoder.rml.model.tags;

public record Error(String message, int line, int column, String type) {
    public Object[] getDataRow() {
        return new Object[]{"", line(), column(), type(), message()};
    }
}
