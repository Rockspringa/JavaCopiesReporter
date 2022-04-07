package edu.mooncoder.rml.controllers.builders;

import edu.mooncoder.rml.exceptions.syntactical.NullTagException;
import edu.mooncoder.rml.exceptions.syntactical.TagNotAllowedException;
import edu.mooncoder.rml.model.contracts.Tag;
import edu.mooncoder.rml.model.tags.Cell;
import edu.mooncoder.rml.model.tags.For;
import edu.mooncoder.rml.model.tags.Row;
import edu.mooncoder.rml.model.tags.Table;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    private static TableBuilder inst;

    private final List<List<Tag>> rowsRepeat = new ArrayList<>();
    private final List<List<Tag>> cellsRepeat = new ArrayList<>();

    private final List<Tag> rowsBattery = new ArrayList<>();
    private final List<Tag> cellsBattery = new ArrayList<>();

    private int level = -1;

    private TableBuilder() {
    }

    public static void initAnalysis() {
        inst = null;
    }

    public void increaseForLevel() {
        rowsRepeat.add(new ArrayList<>());
        cellsRepeat.add(new ArrayList<>());
        level++;
    }

    public void decreaseForLevel() {
        rowsRepeat.remove(level);
        cellsRepeat.remove(level);
        level--;
    }

    public static TableBuilder getInst() {
        if (inst == null) inst = new TableBuilder();
        return inst;
    }

    public void add(Tag tag, int line, int column) {
        if (tag == null) {
            ErrorsReportBuilder.add(new NullTagException(line, column));
        } else if (tag instanceof Row row) {
            add(row);
        } else if (tag instanceof Cell cell) {
            add(cell);
        } else {
            ErrorsReportBuilder.add(new TagNotAllowedException(new Table(new Row[0]), tag, line, column));
        }
    }

    public void addFor(Tag tag, boolean asRow, int line, int column) {
        decreaseForLevel();
        HtmlBuilder.getInst().decreaseForLevel();
        if (tag == null) {
            ErrorsReportBuilder.add(new NullTagException(line, column));
        } else if (tag instanceof For forTag) {
            add(forTag, asRow);
        } else {
            ErrorsReportBuilder.add(new TagNotAllowedException(new Table(new Row[0]), tag, line, column));
        }
    }

    public void clear(boolean rows) {
        if (level > -1) {
            if (rows) rowsRepeat.get(level).clear();
            else cellsRepeat.get(level).clear();
        } else {
            if (rows) rowsBattery.clear();
            else cellsBattery.clear();
        }
    }

    public Tag[] getRows() {
        Tag[] tags = ((level > -1) ? rowsRepeat.get(level) : rowsBattery).toArray(new Tag[0]);

        clear(true);
        return tags;
    }

    public Tag[] getCells() {
        Tag[] tags = ((level > -1) ? cellsRepeat.get(level) : cellsBattery).toArray(new Tag[0]);

        clear(false);
        return tags;
    }

    private void add(Row tag) {
        if (level > -1) rowsRepeat.get(level).add(tag);
        else rowsBattery.add(tag);
    }

    private void add(Cell tag) {
        if (level > -1) cellsRepeat.get(level).add(tag);
        else cellsBattery.add(tag);
    }

    private void add(For tag, boolean asRow) {
        if (asRow) rowsBattery.add(tag);
        else cellsBattery.add(tag);
    }
}
