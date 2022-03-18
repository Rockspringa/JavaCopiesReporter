package edu.mooncoder.model.wrappers;

import java.util.Arrays;
import java.util.Objects;

public record Method(String name, String type, Variable... parameters) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Method method = (Method) o;

        if (!Objects.equals(name, method.name)) return false;
        if (!Objects.equals(type, method.type)) return false;
        return Arrays.equals(parameters, method.parameters);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(parameters);
        return result;
    }
}
