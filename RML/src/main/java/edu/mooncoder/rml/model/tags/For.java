package edu.mooncoder.rml.model.tags;

import edu.mooncoder.rml.controllers.builders.SymbolsTable;
import edu.mooncoder.rml.model.actions.ConstantAction;
import edu.mooncoder.rml.model.actions.VariableAction;
import edu.mooncoder.rml.model.contracts.Action;
import edu.mooncoder.rml.model.contracts.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record For(Tag[] tags, Action beginAction, Action endAction) implements Tag {
    private Table getFormattedTable(Table table) {
        List<Row> rows = new ArrayList<>();
        for (Tag rowTag : table.rows()) {
            if (rowTag instanceof Row row)
                rows.add(getFormattedRow(row));
            else if (rowTag instanceof For forTag)
                rows.addAll(Arrays.stream(forTag.tags()).map(row -> (Row) row).toList());
        }
        return new Table(rows.toArray(new Row[0]));
    }

    private Row getFormattedRow(Row row) {
        List<Cell> cells = new ArrayList<>();
        for (Tag cellTag : row.cells()) {
            if (cellTag instanceof Cell cell)
                cells.add(getFormattedCell(cell));
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

    private Tag getFormattedTag(Tag tag) {
        if (tag instanceof Cell cell) {
            return getFormattedCell(cell);
        } else if (tag instanceof Heading heading) {
            List<ConstantAction> constants = new ArrayList<>();
            for (Action action : heading.actions()) {
                constants.add(new ConstantAction(action.get()));
            }
            return new Cell(constants.toArray(new ConstantAction[0]), heading.big());
        } else if (tag instanceof Row row) {
            return getFormattedRow(row);
        } else if (tag instanceof Table table) {
            return getFormattedTable(table);
        }
        return tag;
    }

    @Override
    public Tag[] tags() {
        List<Tag> listTags = new ArrayList<>();

        while ((int) beginAction.get() <= (int) endAction.get()) {
            listTags.addAll(Arrays.stream(tags).map(this::getFormattedTag).toList());
            if (beginAction instanceof VariableAction var) {
                SymbolsTable.getInst().addOneTo(var.name());
            }
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
            builder.append(tag.getHtmlString());
        }

        return builder.toString();
    }
}
