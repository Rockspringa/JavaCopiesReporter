package edu.mooncoder.rml.controllers.operations;

import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.semantical.TypeNotMatchException;
import edu.mooncoder.rml.model.contracts.Action;

public class Concat {
    private static Concat inst;

    public static Concat getInstance() {
        if (inst == null) inst = new Concat();
        return inst;
    }

    private String getStringOf(Object val) {
        if (val instanceof String s) {
            return s;
        } else if (val instanceof Action a && (a.get() instanceof String || a.get() instanceof Integer)) {
            return a.get().toString();
        } else if (val instanceof Integer i) {
            return i.toString();
        }
        return null;
    }

    private String[] getValues(Object val1, Object val2, int line, int column) {
        String str1 = getStringOf(val1);
        String str2 = getStringOf(val2);

        if (str1 == null || str2 == null) {
            ErrorsReportBuilder.add(new TypeNotMatchException(line, column));
            return null;
        }
        return new String[]{str1, str2};
    }

    public String concat(Object val1, Object val2, int line, int column) {
        String[] values = getValues(val1, val2, line, column);
        if (values != null) {
            return values[0] + values[1];
        }
        return null;
    }

    public String concat(Object val1, Object val2, Object val3, int line, int column) {
        String[] values = getValues(val1, val2, line, column);

        if (values != null) {
            return concat(values[0] + values[1], val3, line, column);
        }
        return null;
    }
}
