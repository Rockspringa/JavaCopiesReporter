package edu.mooncoder.osrn.exceptions;

public class UnknownCharactersException extends AnalysisException {
    public UnknownCharactersException(int line, int col, String characters) {
        super(line, col, String.format("No se reconocio la cadena << %s >>,", characters), "Lexico");
    }
}
