package edu.mooncoder.rml.exceptions.semantical;

import edu.mooncoder.rml.exceptions.SemanticalException;

public class NonePointerException extends SemanticalException {
    public NonePointerException(String name, int line, int column) {
        super("No se encontro la variable '" + name + "'", line, column);
    }
    public NonePointerException(int line, int column) {
        super("Se recibio un nombre 'null'", line, column);
    }
}
