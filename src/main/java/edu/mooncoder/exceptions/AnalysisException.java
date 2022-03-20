package edu.mooncoder.exceptions;

public abstract class AnalysisException extends Exception {
    private final int line, col;

    public AnalysisException(int line, int col, String msg) {
        super(msg);
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return String.format("%s en la linea %d y columna %d.", getMessage(), line, col);
    }
}
