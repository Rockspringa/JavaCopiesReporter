package edu.mooncoder.model.types;

public enum ErrorType {
    SYNTACTICAL("Sintactico"), LEXICAL("Lexico");

    private final String msg;

    private ErrorType(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
