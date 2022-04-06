package edu.mooncoder.model.wrappers;

import java.util.Arrays;
import java.util.Objects;

public record Class(String name, String[] functions) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        if (!Objects.equals(name, aClass.name)) return false;
        return Arrays.equals(functions, aClass.functions);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(functions);
        return result;
    }
}
