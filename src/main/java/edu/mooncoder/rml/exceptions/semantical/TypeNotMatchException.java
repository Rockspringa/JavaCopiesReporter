package edu.mooncoder.rml.exceptions.semantical;

import edu.mooncoder.rml.exceptions.SemanticalException;

public class TypeNotMatchException extends SemanticalException {
    public TypeNotMatchException(int line, int column) {
        super("El tipo de la variable no coincide con el valor.", line, column);
    }
}
