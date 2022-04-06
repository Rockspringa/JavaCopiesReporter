package edu.mooncoder.osrn.exceptions;

public class MismatchException extends AnalysisException {
    public MismatchException(int line, int col, String esperado) {
        super(line, col, String.format("Se esperaba un%s,", esperado), "Sintactico");
    }
}
