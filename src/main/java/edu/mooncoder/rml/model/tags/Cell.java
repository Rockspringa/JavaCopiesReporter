package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.Tag;

public record Cell(Action[] actions, boolean title) implements Tag {
    @Override
    public String getTagName() {
        return (title()) ? "Title Cell" : "Data Cell";
    }

    @Override
    public String getHtmlString() {
        String tag = (title()) ? "<th" : "<td";
        String tagClose = (title()) ? "</th>" : "</td>";
        StringBuilder builder = new StringBuilder(tag);

        builder.append(" style=\"color: rgb(160, 168, 180); ");
        builder.append("border: solid 1px rgb(171, 178, 192)\">");
        for (Action action : actions()) {
            builder.append(action.get());
        }
        builder.append(tagClose);

        return builder.toString();
    }
}
