package edu.mooncoder.osrn.exceptions;

public abstract class AnalysisException extends Exception {
    private final int line, col;
    private final String type;

    public AnalysisException(int line, int col, String msg, String type) {
        super(msg);
        this.line = line;
        this.col = col;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s en la linea %d y columna %d.", getMessage(), line, col);
    }

    public Object[] getDataRow() {
        return new Object[]{"", line, col, type, getMessage()};
    }
}
