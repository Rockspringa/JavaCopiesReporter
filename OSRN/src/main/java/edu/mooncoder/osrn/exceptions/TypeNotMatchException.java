package edu.mooncoder.osrn.exceptions;

public class TypeNotMatchException extends Exception {
    public TypeNotMatchException(String key, String type) {
        super(String.format("El objeto '%s' no coincide con el tipo '%s'.", key, type));
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
