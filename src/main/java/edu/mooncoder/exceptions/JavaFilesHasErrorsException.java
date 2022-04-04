package edu.mooncoder.exceptions;

public class JavaFilesHasErrorsException extends Exception {
    public JavaFilesHasErrorsException() {
        super("Los archivos enviados tienen errores.");
    }
}
