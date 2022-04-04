package edu.mooncoder.rml.exceptions;

public abstract class SemanticalException extends AnalysisException {
    public SemanticalException(String message, int line, int column) {
        super(message, line, column);
    }

    public String is() {
        return "Semantico";
    }
}
