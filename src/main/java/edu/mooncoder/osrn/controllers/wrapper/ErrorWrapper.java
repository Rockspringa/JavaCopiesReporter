package edu.mooncoder.osrn.controllers.wrapper;

import edu.mooncoder.osrn.exceptions.MismatchException;
import edu.mooncoder.osrn.exceptions.UnknownCharactersException;

import java.util.ArrayList;
import java.util.List;

public class ErrorWrapper {
    private static ErrorWrapper instance = new ErrorWrapper();
    private final List<Exception> list;

    private ErrorWrapper() {
        list = new ArrayList<>();
    }

    public static void add(int line, int col, String value) {
        if (instance == null)
            instance = new ErrorWrapper();
        instance.list.add(new MismatchException(line, col, value));
    }

    public static void addLexicalError(int line, int col, String value) {
        if (instance == null)
            instance = new ErrorWrapper();
        instance.list.add(new UnknownCharactersException(line, col, value));
    }

    public static Object[] close() {
        if (instance == null)
            instance = new ErrorWrapper();
        Object[] list = instance.list.toArray(new Object[0]);
        instance = null;
        return list;
    }

    @Override
    public String toString() {
        return "ErrorWrapper{" +
                "list=" + list +
                '}';
    }
}
