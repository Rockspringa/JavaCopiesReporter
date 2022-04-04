package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Tag;

public record Row(Tag[] cells) implements Tag {
    @Override
    public String getTagName() {
        return "Table Row";
    }

    @Override
    public String getHtmlString() {
        StringBuilder builder = new StringBuilder("<tr>");

        for (Tag cell : cells()) {
            builder.append(cell.getHtmlString());
        }
        builder.append("</tr>");

        return builder.toString();
    }
}
