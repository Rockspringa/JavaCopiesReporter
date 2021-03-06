package edu.mooncoder.osrn.services;

import edu.mooncoder.osrn.controllers.analyzer.lexic.JsonLexer;
import edu.mooncoder.osrn.controllers.analyzer.syntax.JsonParser;
import edu.mooncoder.osrn.controllers.wrapper.ErrorWrapper;
import edu.mooncoder.osrn.exceptions.AnalysisException;
import edu.mooncoder.osrn.model.containers.Osrn;

import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OsrnFactory {
    private AnalysisException[] errors = new AnalysisException[0];

    private Osrn getOsrnByReader(Reader reader) throws Exception {
        JsonLexer lexer = new JsonLexer(reader);
        JsonParser parser = new JsonParser(lexer);

        try {
            parser.parse();

            errors = ErrorWrapper.close();
            if (errors.length == 0)
                return parser.getOsrn();
            else
                return null;
        } catch (Exception rethrow) {
            errors = ErrorWrapper.close();
            throw rethrow;
        }
    }

    public AnalysisException[] getErrors() {
        return errors;
    }

    public Osrn getOsrnByString(String data) throws Exception {
        StringReader reader = new StringReader(data);

        return getOsrnByReader(reader);
    }

    public Osrn getOsrnByFilename(String filename) throws Exception {
        FileReader reader = new FileReader(filename);

        return getOsrnByReader(reader);
    }

    public static Osrn getOsrnByMap(Map<?, ?> map) {
        Osrn osrn = new Osrn();

        for (Map.Entry<?, ?> pair : map.entrySet()) {
            if (pair.getValue() instanceof Map<?, ?> _map)
                osrn.addPair((String) pair.getKey(), getOsrnByMap(_map));
            else if (pair.getValue() instanceof List<?> list)
                osrn.addPair((String) pair.getKey(), getOsrnListByList(list));
            else
                osrn.addPair((String) pair.getKey(), pair.getValue());
        }

        return osrn;
    }

    public static Object[] getOsrnListByList(List<?> list) {
        List<Object> out = new ArrayList<>();

        for (Object obj : list) {
            if (obj instanceof Map<?, ?> map)
                out.add(getOsrnByMap(map));
            else if (obj instanceof List<?> _list)
                out.add(getOsrnListByList(_list));
            else
                out.add(obj);
        }

        return out.toArray(new Object[0]);
    }
}
