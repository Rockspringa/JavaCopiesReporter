package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Tag;

public record Document(Tag[] tags) implements Tag {
    @Override
    public String getTagName() {
        return "HTML Document";
    }

    @Override
    public String getHtmlString() {
        StringBuilder builder = new StringBuilder("<html>");

        for (Tag tag : tags()) {
            builder.append(tag.getHtmlString());
        }
        builder.append("</html>");

        return builder.toString();
    }
}
