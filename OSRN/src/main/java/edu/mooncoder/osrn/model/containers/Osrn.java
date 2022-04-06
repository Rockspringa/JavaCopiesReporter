package edu.mooncoder.osrn.model.containers;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Osrn implements Serializable {
    private static int spaces = 0;
    private final Map<String, Object> map;

    public Osrn() {
        map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void addPair(String key, Object value) {
        map.put(key, value);
    }

    public Object getValue(String key) {
        return map.get(key);
    }

    @Override
    public String toString() {
        if (map.isEmpty())
            return "{}";

        StringBuffer buf = new StringBuffer();
        buf.append("{\n");
        spaces += 2;

        for (Map.Entry<String, Object> pair : map.entrySet()) {
            addSpaces(buf);
            addFormattedObject(pair.getKey(), buf);
            buf.append(": ");
            addFormattedObject(pair.getValue(), buf);
            buf.append(",\n");
        }

        if (!map.isEmpty())
            buf.deleteCharAt(buf.length() - 2);

        spaces -= 2;
        addSpaces(buf);
        buf.append("}");

        return buf.toString();
    }

    private void addSpaces(StringBuffer buf) {
        buf.append(" ".repeat(Math.max(0, spaces)));
    }

    private void addFormattedObject(Object obj, StringBuffer buf) {
        if (obj == null) {
            buf.append("null");
        } else if (obj.getClass().isArray()) {
            Object[] objs = (Object[]) obj;
            buf.append("[\n");
            spaces += 2;

            for (int i = 0; i < objs.length; i++) {
                addSpaces(buf);
                addFormattedObject(objs[i], buf);
                if (i < objs.length - 1)
                    buf.append(",");
                buf.append("\n");
            }

            spaces -= 2;
            addSpaces(buf);
            buf.append("]");
        } else if (obj instanceof String str) {
            buf.append(String.format("\"%s\"", str));
        } else {
            buf.append(obj);
        }
    }
}
