package edu.mooncoder.rml.exceptions;

public class BadWrittenRmlException extends Exception {
    public BadWrittenRmlException() {
        super("El archivo tiene errores, consulte la base de errores para mas informacion.");
    }
}
