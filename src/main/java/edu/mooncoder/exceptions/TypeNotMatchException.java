package edu.mooncoder.exceptions;

public class TypeNotMatchException extends Exception {
    public TypeNotMatchException(String key, String type) {
        super(String.format("El objeto '%s' no coincide con el tipo '%s'.", key, type));
    }
}
