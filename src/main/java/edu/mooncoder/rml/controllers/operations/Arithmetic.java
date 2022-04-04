package edu.mooncoder.rml.controllers.operations;

import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.syntactical.NotIntegerValueException;
import edu.mooncoder.rml.model.contracts.Action;

public class Arithmetic {
    private static Arithmetic inst;

    public static Arithmetic getInstance() {
        if (inst == null) inst = new Arithmetic();
        return inst;
    }

    private Integer getIntOf(Object val) {
        if (val instanceof Integer i) {
            return i;
        } else if (val instanceof Action a && a.get() instanceof Integer i) {
            return i;
        }
        return null;
    }

    private int[] getValues(Object val1, Object val2, int line, int column) {
        Integer int1 = getIntOf(val1);
        Integer int2 = getIntOf(val2);

        if (int1 == null || int2 == null) {
            ErrorsReportBuilder.add(new NotIntegerValueException(line, column));
            return null;
        }
        return new int[]{int1, int2};
    }

    public int add(Object val1, Object val2, int line, int column) {
        int[] values = getValues(val1, val2, line, column);
        if (values != null) {
            return values[0] + values[1];
        }
        return 0;
    }

    public int reduce(Object val1, Object val2, int line, int column) {
        int[] values = getValues(val1, val2, line, column);
        if (values != null) {
            return values[0] - values[1];
        }
        return 0;
    }

    public int times(Object val1, Object val2, int line, int column) {
        int[] values = getValues(val1, val2, line, column);
        if (values != null) {
            return values[0] * values[1];
        }
        return 0;
    }

    public int div(Object val1, Object val2, int line, int column) {
        int[] values = getValues(val1, val2, line, column);
        if (values != null) {
            return values[0] / values[1];
        }
        return 0;
    }
}
