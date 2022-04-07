package edu.mooncoder.rml.exceptions;

public abstract class SyntaticalException extends AnalysisException {
    public SyntaticalException(String message, int line, int column) {
        super(message, line, column);
    }

    public String is() {
        return "Sintactico";
    }
}
