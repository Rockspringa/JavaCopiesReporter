package edu.mooncoder.model.containers;

import edu.mooncoder.model.types.ErrorType;
import edu.mooncoder.model.wrappers.Error;

import java.util.ArrayList;
import java.util.List;

public class ErrorsHolder {
    private static ErrorsHolder inst;
    private final List<Error> errors;
    private static String filename = "Sin nombre";
    private static int project = 1;

    private ErrorsHolder() {
        errors = new ArrayList<>();
    }

    public static void setFilename(String filename) {
        ErrorsHolder.filename = filename;
    }

    public static void changeProject() {
        ErrorsHolder.project++;
    }

    public static void addSyntacticalError(int line, int column, String message) {
        if (inst == null) {
            inst = new ErrorsHolder();
        }
        if (message != null && line != -1 && column != -1)
            inst.add(ErrorType.SYNTACTICAL, line, column, String.format("Se esperaba un%s.", message));
    }

    public static void addLexicalError(int line, int column, String message) {
        if (inst == null) {
            inst = new ErrorsHolder();
        }
        if (message != null && line != -1 && column != -1)
            inst.add(ErrorType.LEXICAL, line, column, String.format("No se reconocio la cadena << %s >>.", message));
    }

    public static List<Error> clean() {
        if (inst == null) {
            inst = new ErrorsHolder();
        }
        List<Error> classes = inst.errors;

        filename = "Sin nombre";
        project = 1;
        inst = null;

        return classes;
    }

    public static boolean hasErrors() {
        return inst != null && !inst.errors.isEmpty();
    }

    public void add(ErrorType type, int line, int column, String message) {
        errors.add(new Error(type, filename, project, line, column, message));
    }
}
