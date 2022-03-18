package edu.mooncoder.model.wrappers;

import java.util.Objects;

public class Variable {
    private final String name, type;
    private String scope;

    public Variable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        if (this.scope != null)
            this.scope = String.format("%s, %s", this.scope, scope);
        else
            this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        if (!Objects.equals(name, variable.name)) return false;
        return Objects.equals(type, variable.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
