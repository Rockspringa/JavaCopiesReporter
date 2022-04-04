package edu.mooncoder.rml.exceptions.syntactical;

import edu.mooncoder.rml.exceptions.SyntaticalException;

public class IrreparableException extends SyntaticalException {
    public IrreparableException(int line, int column) {
        super("La sintaxis esta tan mal que la computadora se rindio.", line, column);
    }
}
