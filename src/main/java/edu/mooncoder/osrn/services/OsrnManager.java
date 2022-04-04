package edu.mooncoder.osrn.services;

import edu.mooncoder.osrn.exceptions.TypeNotMatchException;
import edu.mooncoder.osrn.model.containers.Osrn;

import java.util.Arrays;

public record OsrnManager(Osrn osrn) {
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

    public Object getValue(String key) throws TypeNotMatchException {
        if (osrn.getValue(key) instanceof Object[]) {
            throw new TypeNotMatchException(key, "text, numero o objeto");
        } else {
            return osrn.getValue(key);
        }
    }
}
