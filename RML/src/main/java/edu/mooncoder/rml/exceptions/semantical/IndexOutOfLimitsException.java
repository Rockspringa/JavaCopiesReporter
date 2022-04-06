package edu.mooncoder.rml.exceptions.semantical;

import edu.mooncoder.rml.exceptions.SemanticalException;

public class IndexOutOfLimitsException extends SemanticalException {
    public IndexOutOfLimitsException(int index, int bounds, int line, int column) {
        super("Posicion " + index + " fuera de la longitud " + bounds + ".", line, column);
    }
}
