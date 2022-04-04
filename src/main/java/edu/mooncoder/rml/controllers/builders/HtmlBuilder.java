package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.rml.exceptions.syntactical.NullTagException;
import edu.mooncoder.rml.exceptions.syntactical.TagNotAllowedException;
import edu.mooncoder.rml.model.contracts.Tag;
import edu.mooncoder.rml.model.tags.Cell;
import edu.mooncoder.rml.model.tags.Document;
import edu.mooncoder.rml.model.tags.Row;

import java.util.ArrayList;
import java.util.List;

public class HtmlBuilder {
    private static HtmlBuilder inst;

    private final List<Tag> tagsToRepeat = new ArrayList<>();
    private final List<Tag> tagsBattery = new ArrayList<>();

    private boolean repeat = false;

    private HtmlBuilder() {
    }

    public static HtmlBuilder getInst() {
        if (inst == null) inst = new HtmlBuilder();
        return inst;
    }

    public static void initAnalysis() {
        inst = null;
    }

    public static void toggleRepeat() {
        getInst().repeat = !inst.repeat;
    }

    public void addTag(Tag tag, int line, int column) {
        if (tag instanceof Row || tag instanceof Cell) {
            ErrorsReportBuilder.add(new TagNotAllowedException(new Document(new Tag[0]), tag, line, column));
        } else if (tag == null) {
            ErrorsReportBuilder.add(new NullTagException(line, column));
        } else {
            add(tag);
        }
    }

    public void clear() {
        if (repeat) {
            tagsToRepeat.clear();
            toggleRepeat();
            TableBuilder.deactivateRepeat();
        } else {
            tagsBattery.clear();
        }
    }

    public Tag[] getTags() {
        Tag[] tags = ((repeat) ? tagsToRepeat : tagsBattery).toArray(new Tag[0]);

        clear();
        return tags;
    }

    private void add(Tag tag) {
        if (repeat) tagsToRepeat.add(tag);
        else tagsBattery.add(tag);
    }
}
