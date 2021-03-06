package edu.mooncoder.osrn.controllers.wrapper;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.model.containers.Pair;

import java.util.ArrayList;
import java.util.List;

public class OsrnWrapper {
    private static final List<OsrnWrapper> instances = new ArrayList<>();
    private static int level = -1;
    private final Osrn osrn;

    private OsrnWrapper() {
        osrn = new Osrn();
    }

    public static void addFirstPair(Pair pair) {
        instances.add(new OsrnWrapper());
        level++;
        addPair(pair);
    }

    public static void addEmpty() {
        instances.add(new OsrnWrapper());
        level++;
    }

    public static void addPair(Pair pair) {
        if (pair != null)
            instances.get(level).osrn.addPair(pair.key(), pair.value());
    }

    public static Osrn close() {
        if (instances.size() == 0 || instances.size() <= level) {
            addEmpty();
        }
        Osrn osrn = instances.get(level).osrn;
        instances.remove(level--);
        return osrn;
    }
}
