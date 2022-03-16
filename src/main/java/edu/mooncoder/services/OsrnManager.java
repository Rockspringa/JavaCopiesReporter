package edu.mooncoder.services;

import edu.mooncoder.exceptions.TypeNotMatchException;
import edu.mooncoder.model.containers.Osrn;

import java.util.Arrays;

public class OsrnManager {
    private final Osrn osrn;

    public OsrnManager(Osrn osrn) {
        this.osrn = osrn;
    }

    public String getArrayToString(String key) throws TypeNotMatchException {
        if (osrn.getValue(key) instanceof Object[] objs) {
            return Arrays.toString(objs);
        } else {
            throw new TypeNotMatchException(key, "arreglo");
        }
    }

    public Object[] getArray(String key) throws TypeNotMatchException {
        if (osrn.getValue(key) instanceof Object[] objs) {
            return objs;
        } else {
            throw new TypeNotMatchException(key, "arreglo");
        }
    }

    public String getString(String key) throws TypeNotMatchException {
        if (osrn.getValue(key) instanceof String str) {
            return str;
        } else {
            throw new TypeNotMatchException(key, "string");
        }
    }

    public double getNumber(String key) throws TypeNotMatchException {
        if (osrn.getValue(key) instanceof Double number) {
            return number;
        } else {
            throw new TypeNotMatchException(key, "number");
        }
    }

    public OsrnManager getOsrn(String key) throws TypeNotMatchException {
        if (this.osrn.getValue(key) instanceof Osrn osrn) {
            return new OsrnManager(osrn);
        } else {
            throw new TypeNotMatchException(key, "ObjectScript Report Notation");
        }
    }
}
