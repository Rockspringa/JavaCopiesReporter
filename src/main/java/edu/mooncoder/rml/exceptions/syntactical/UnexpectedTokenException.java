package edu.mooncoder.rml.exceptions.syntactical;

import edu.mooncoder.rml.exceptions.SyntaticalException;

public class UnexpectedTokenException extends SyntaticalException {
    public UnexpectedTokenException(String expected, int line, int column) {
        super("Se esperaba un" + expected + ".", line, column);
    }
}
