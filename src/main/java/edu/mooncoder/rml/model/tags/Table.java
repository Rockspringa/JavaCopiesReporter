package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Tag;

public record Table(Tag[] rows) implements Tag {
    @Override
    public String getTagName() {
        return "Table";
    }

    @Override
    public String getHtmlString() {
        StringBuilder builder = new StringBuilder("<table style=\"border: solid 2px rgb(61, 66, 75)\">");

        for (Tag row : rows()) {
            builder.append(row.getHtmlString());
        }
        builder.append("</table>");

        return builder.toString();
    }
}
