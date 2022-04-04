package edu.mooncoder.rml.exceptions.syntactical;

import edu.mooncoder.rml.exceptions.SemanticalException;

public class NotIntegerValueException extends SemanticalException {
    public NotIntegerValueException(int line, int column) {
        super("Solo se pueden usar valores enteros.", line, column);
    }
}
