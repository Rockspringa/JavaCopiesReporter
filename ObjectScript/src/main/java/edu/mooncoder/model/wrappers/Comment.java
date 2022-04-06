package edu.mooncoder.model.wrappers;

import java.util.Objects;

public record Comment(String comment) {
    public Comment(String comment) {
        String begin = "^(/[*]|//)[ \\n\\r\\t]*";
        String lineBegin = "[ \\r\\t]*[*][ \\r\\t]*";
        String lineEnd = "[ \\r\\t]*[\\n][ \\r\\t]*";
        String end = "[ \\n\\r\\t]*([*]/)?$";

        this.comment = comment.replaceAll(String.format("%s|%s|%s|%s",
                begin, lineBegin, lineEnd, end), "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        return Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return comment != null ? comment.hashCode() : 0;
    }
}
