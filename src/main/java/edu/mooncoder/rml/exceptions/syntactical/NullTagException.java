package edu.mooncoder.rml.exceptions.syntactical;

import edu.mooncoder.rml.exceptions.SyntaticalException;

public class NullTagException extends SyntaticalException {
    public NullTagException(int line, int column) {
        super("No se pudo construir una etiqueta.", line, column);
    }
}
