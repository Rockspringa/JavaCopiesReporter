package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.controllers.builders.SymbolsTable;
import edu.mooncoder.rml.model.actions.ConstantAction;
import edu.mooncoder.rml.model.actions.VariableAction;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record For(Tag[] tags, VariableAction beginAction, VariableAction endAction) implements Tag {
    private Table getFormattedTable(Table table) {
        List<Row> rows = new ArrayList<>();
        for (Tag rowTag : table.rows()) {
            if (rowTag instanceof Row row) rows.add(getFormattedRow(row));
            else if (rowTag instanceof For forTag)
                rows.addAll(Arrays.stream(forTag.tags()).map(row -> (Row) row).toList());
        }
        return new Table(rows.toArray(new Row[0]));
    }

    private Row getFormattedRow(Row row) {
        List<Cell> cells = new ArrayList<>();
        for (Tag cellTag : row.cells()) {
            if (cellTag instanceof Cell cell) cells.add(getFormattedCell(cell));
            else if (cellTag instanceof For forTag)
                cells.addAll(Arrays.stream(forTag.tags()).map(cell -> (Cell) cell).toList());
        }
        return new Row(cells.toArray(new Cell[0]));
    }

    private Cell getFormattedCell(Cell cell) {
        List<ConstantAction> constants = new ArrayList<>();
        for (Action action : cell.actions()) {
            constants.add(new ConstantAction(action.get()));
        }
        return new Cell(constants.toArray(new ConstantAction[0]), cell.title());
    }

    private For getFormattedFor(For forTag) {
        List<Tag> tags = new ArrayList<>();
        for (Tag tag : forTag.tags()) {
            tags.add(getFormattedTag(tag));
        }
        return new For(tags.toArray(new Tag[0]), forTag.beginAction(), forTag.endAction());
    }

    private Tag getFormattedTag(Tag tag) {
        if (tag instanceof Cell cell) {
            return getFormattedCell(cell);
        } else if (tag instanceof Heading heading) {
            List<ConstantAction> constants = new ArrayList<>();
            for (Action action : heading.actions()) {
                constants.add(new ConstantAction(action.get()));
            }
            return new Heading(constants.toArray(new ConstantAction[0]), heading.big());
        } else if (tag instanceof Row row) {
            return getFormattedRow(row);
        } else if (tag instanceof Table table) {
            return getFormattedTable(table);
        } else if (tag instanceof For forTag) {
            return getFormattedFor(forTag);
        }
        return tag;
    }

    @Override
    public Tag[] tags() {
        List<Tag> listTags = new ArrayList<>();

        while ((int) beginAction.get() <= (int) endAction.get()) {
            listTags.addAll(Arrays.stream(tags).map(this::getFormattedTag).toList());
            SymbolsTable.getInst().addOneTo(beginAction().name());
        }

        return listTags.toArray(new Tag[0]);
    }

    @Override
    public String getTagName() {
        return "For";
    }

    @Override
    public String getHtmlString() {
        StringBuilder builder = new StringBuilder();

        for (Tag tag : tags()) {
            if (tag instanceof For forTag) {
                for (Tag innerTag : forTag.tags) {
                    builder.append(innerTag.getHtmlString());
                }
            } else {
                builder.append(tag.getHtmlString());
            }
        }

        return builder.toString();
    }
}
