package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.Tag;

public record Heading(Action[] actions, boolean big) implements Tag {
    @Override
    public String getTagName() {
        return "Heading";
    }

    @Override
    public String getHtmlString() {
        String tag = (big()) ? "<h1" : "<h3";
        String tagClose = (big()) ? "</h1>" : "</h3>";
        StringBuilder builder = new StringBuilder(tag);

        builder.append(" style=\"color: rgb(160, 168, 180)\">");
        for (Action action : actions()) {
            builder.append(action.get());
        }
        builder.append(tagClose);

        return builder.toString();
    }
}
