package edu.mooncoder.rml.exceptions;

public abstract class AnalysisException extends Exception {
    private final int line;
    private final int column;

    public AnalysisException(String message, int line, int column) {
        super(message);
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract String is();
}
