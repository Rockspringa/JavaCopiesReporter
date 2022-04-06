package edu.mooncoder.copy.controllers.containers;

import edu.mooncoder.copy.model.PathFile;

import java.util.ArrayList;
import java.util.List;

public class StructureHolder {
    private static StructureHolder inst;

    private final List<PathFile> files = new ArrayList<>();

    public static void addFile(String filename, String path) {
        if (inst == null)
            inst = new StructureHolder();

        if (filename != null && path != null)
            inst.add(filename, path);
    }

    public static PathFile[] close() {
        if (inst == null)
            inst = new StructureHolder();

        PathFile[] files = inst.files.toArray(new PathFile[0]);
        inst = null;

        return files;
    }

    public void add(String filename, String path) {
        files.add(new PathFile(filename, path));
    }
}
