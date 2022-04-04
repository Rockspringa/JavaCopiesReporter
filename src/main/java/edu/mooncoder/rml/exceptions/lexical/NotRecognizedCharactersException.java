package edu.mooncoder.rml.exceptions.lexical;

import edu.mooncoder.rml.exceptions.AnalysisException;

public class NotRecognizedCharactersException extends AnalysisException {
    public NotRecognizedCharactersException(String chars, int line, int col) {
        super("No se reconocio la cadena << " + chars + " >>.", line, col);
    }

    @Override
    public String is() {
        return "Lexico";
    }
}
