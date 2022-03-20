package edu.mooncoder.controllers.wrapper;

import edu.mooncoder.model.containers.Pair;

public class PairWrapper {
    private static Pair pair;

    private PairWrapper() {}

    public static void setPair(String key, Object value) {
        pair = new Pair(key, value);
    }

    public static Pair getPair() {
        Pair _pair = pair;
        pair = null;
        return _pair;
    }
}
