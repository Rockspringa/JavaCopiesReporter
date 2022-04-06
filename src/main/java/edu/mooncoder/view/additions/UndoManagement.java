package edu.mooncoder.view.additions;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoManagement {
    public static class Undo extends AbstractAction {
        private final UndoManager undoManager;

        public Undo(UndoManager undoManager) {
            super("Undo");
            this.undoManager = undoManager;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            } catch (CannotUndoException ignored) {
            }
        }
    }

    public static class Redo extends AbstractAction {
        private final UndoManager undoManager;

        public Redo(UndoManager undoManager) {
            super("Redo");
            this.undoManager = undoManager;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            } catch (CannotUndoException ignored) {
            }
        }
    }

    public static class Undoable implements UndoableEditListener {
        private final UndoManager undoManager;

        public Undoable(UndoManager undoManager) {
            this.undoManager = undoManager;
        }

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
        }
    }
}
