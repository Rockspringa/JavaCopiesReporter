package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.rml.exceptions.semantical.NonePointerException;
import edu.mooncoder.rml.exceptions.semantical.TypeNotMatchException;
import edu.mooncoder.rml.model.contracts.Variable;
import edu.mooncoder.rml.model.variables.Int;
import edu.mooncoder.rml.model.variables.Text;

import java.util.Map;
import java.util.TreeMap;

public class SymbolsTable {
    private static SymbolsTable inst;

    private final Map<String, Variable> symbols = new TreeMap<>();

    private SymbolsTable() {
    }

    public static SymbolsTable getInst() {
        if (inst == null) inst = new SymbolsTable();
        return inst;
    }

    public static void addGlobal(Osrn osrn) {
        inst = new SymbolsTable();
        inst.symbols.put("RESULT", new Variable() {
            @Override
            public Object getValue() {
                return osrn;
            }

            @Override
            public String getTagName() {
                return "ObjectScript Report Notation";
            }

            @Override
            public String getHtmlString() {
                return osrn.toString();
            }
        });
    }

    public void update(String key, Object obj, int line, int column) {
        if (key != null) updateVariable(key, obj, line, column);
        else ErrorsReportBuilder.add(new NonePointerException(line, column));
    }

    public void add(String key, Object obj, String type, int line, int column) {
        if (key != null) addVariable(key, obj, type, line, column);
        else ErrorsReportBuilder.add(new NonePointerException(line, column));
    }

    public void addOneTo(String key) {
        if (!symbols.containsKey(key)) ErrorsReportBuilder.add(new NonePointerException(-1, -1));
        if (symbols.get(key) instanceof Int value) symbols.put(key, new Int(value.value() + 1));
    }

    public Object get(String key, int line, int column) {
        if (!symbols.containsKey(key)) {
            ErrorsReportBuilder.add(new NonePointerException(key, line, column));
            return null;
        }
        return symbols.get(key).getValue();
    }

    private void updateVariable(String key, Object obj, int line, int column) {
        if (symbols.containsKey(key)) {
            if (symbols.get(key) instanceof Int) {
                if (obj instanceof Integer value) {
                    symbols.put(key, new Int(value));
                    return;
                }
            } else if (symbols.get(key) instanceof Text) {
                if (obj instanceof String value) {
                    symbols.put(key, new Text(value));
                    return;
                }
            }
            ErrorsReportBuilder.add(new TypeNotMatchException(line, column));
        } else {
            ErrorsReportBuilder.add(new NonePointerException(line, column));
        }
    }

    private void addVariable(String key, Object obj, String type, int line, int column) {
        if (type.equalsIgnoreCase("Integer")) {
            if (obj instanceof Integer value) {
                symbols.put(key, new Int(value));
                return;
            }
        } else if (type.equalsIgnoreCase("String")) {
            if (obj instanceof String value) {
                symbols.put(key, new Text(value));
                return;
            }
        }
        ErrorsReportBuilder.add(new TypeNotMatchException(line, column));
    }
}
