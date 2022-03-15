package edu.mooncoder.model.containers;

import java.util.HashMap;
import java.util.Map;

public class Osrn {
    private static int spaces = 0;
    private Map<String, Object> map;

    public void addPair(String key, Object value) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, value);
    }

    @Override
    public String toString() {
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
