package edu.mooncoder.exceptions;

public class UnknownCharactersException extends AnalysisException {
    public UnknownCharactersException(int line, int col, String characteres) {
        super(line, col, String.format("No se reconocio la cadena << %s >>,", characteres));
    }
}
