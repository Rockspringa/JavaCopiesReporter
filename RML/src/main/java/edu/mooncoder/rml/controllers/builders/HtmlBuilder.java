package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.rml.exceptions.syntactical.NullTagException;
import edu.mooncoder.rml.exceptions.syntactical.TagNotAllowedException;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.Tag;
import edu.mooncoder.rml.model.tags.Cell;
import edu.mooncoder.rml.model.tags.Document;
import edu.mooncoder.rml.model.tags.Row;

import java.util.ArrayList;
import java.util.List;

public class HtmlBuilder {
    private static HtmlBuilder inst;

    private final List<List<Tag>> tagsToRepeat = new ArrayList<>();
    private final List<Tag> tagsBattery = new ArrayList<>();

    private int level = -1;

    private HtmlBuilder() {
    }

    public static HtmlBuilder getInst() {
        if (inst == null) inst = new HtmlBuilder();
        return inst;
    }

    public static void initAnalysis() {
        inst = null;
    }

    public void increaseForLevel() {
        tagsToRepeat.add(new ArrayList<>());
        level++;
    }

    public void decreaseForLevel() {
        tagsToRepeat.remove(level);
        level--;
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

    public void addMultiTag(Action[] tags) {
        for (Tag tag : tags) {
            add(tag);
        }
    }

    public void clear() {
        if (level > -1) {
            decreaseForLevel();
            TableBuilder.getInst().decreaseForLevel();
        } else {
            tagsBattery.clear();
        }
    }

    public Tag[] getTags() {
        Tag[] tags = ((level > -1) ? tagsToRepeat.get(level) : tagsBattery).toArray(new Tag[0]);

        clear();
        return tags;
    }

    private void add(Tag tag) {
        if (level > -1) tagsToRepeat.get(level).add(tag);
        else tagsBattery.add(tag);
    }
}
