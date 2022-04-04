package edu.mooncoder.rml.exceptions.syntactical;

import edu.mooncoder.rml.exceptions.SyntaticalException;
import edu.mooncoder.rml.model.contracts.Tag;

public class TagNotAllowedException extends SyntaticalException {
    public TagNotAllowedException(Tag parent, Tag child, int line, int column) {
        super("La etiqueta '" + parent + "' no puede contener etiquetas '" + child + "'.", line, column);
    }
}
