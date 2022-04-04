package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.model.contracts.Tag;

public record BreakLine() implements Tag {
    @Override
    public String getTagName() {
        return "Breakline";
    }

    @Override
    public String getHtmlString() {
        return "<br />";
    }
}
