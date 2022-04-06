package edu.mooncoder.view.components;

import edu.mooncoder.view.additions.DocumentListeners;
import edu.mooncoder.view.additions.UndoManagement;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

import static edu.mooncoder.view.contracts.LookTheme.FG_INPUT;
import static edu.mooncoder.view.contracts.LookTheme.FG_LABEL;

public class TextPaneWithListeners extends JPanel {
    private JTextPane asideTextPane;
    private JTextPane inputTextPane;
    private final JLabel caretInfo;

    private final Action undoAction;
    private final Action redoAction;
    private final Action cutAction = new DefaultEditorKit.CutAction();
    private final Action copyAction = new DefaultEditorKit.CopyAction();
    private final Action pasteAction = new DefaultEditorKit.PasteAction();

    private void setScrollerStyle(JScrollPane scrollerMaster, JScrollPane scrollerSlave) {
        scrollerMaster.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        scrollerMaster.getHorizontalScrollBar().setUI(new BasicScrollBarUI());

        scrollerSlave.getVerticalScrollBar().setModel(scrollerMaster.getVerticalScrollBar().getModel());
        scrollerSlave.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollerSlave.setHorizontalScrollBar(null);
    }

    private void setAsideTextPane() {
        asideTextPane = new JTextPane();
        asideTextPane.setText("    ");
        asideTextPane.setEditable(false);

        StyledDocument doc = asideTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);

        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        DefaultCaret caret = (DefaultCaret) asideTextPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    }

    private void setInputTextPane(UndoManager undoManager) {
        inputTextPane = new JTextPane();
        Document document = inputTextPane.getDocument();

        inputTextPane.setCaretColor(FG_INPUT);
        inputTextPane.getActionMap().put("Undo", undoAction);
        inputTextPane.getActionMap().put("Redo", redoAction);

        inputTextPane.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
        inputTextPane.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");

        inputTextPane.addCaretListener(this::updateCaretPosition);

        document.addUndoableEditListener(new UndoManagement.Undoable(undoManager));
        document.addDocumentListener(new DocumentListeners.NumberCounter(this::updateNumbers));
    }

    private void updateNumbers() {
        StringBuilder sb = new StringBuilder();
        int offset = inputTextPane.getDocument().getLength();

        int max = 0;
        try {
            max = inputTextPane.getDocument().getText(0, offset).split("\n").length;
        } catch (BadLocationException e) {
            System.out.println("Ocurrio un error contando la cantidad de filas");
        }

        for (int i = 1; i <= max; i++)
            sb.append(i).append("\n");
        sb.append("    \n");

        asideTextPane.setText(sb.toString());
    }

    private void updateCaretPosition(CaretEvent event) {
        int line = 1;
        int col = 1;

        int caret = inputTextPane.getCaretPosition();
        try {
            char[] chars = inputTextPane.getDocument().getText(0, caret).toCharArray();
            for (int i = 0; i < caret; i++) {
                if (chars[i] == '\n') {
                    line++;
                    col = 1;
                } else if (chars[i] != '\f' && chars[i] != '\r') {
                    col++;
                }
            }
        } catch (BadLocationException ignored) {
        }

        int diff = inputTextPane.getSelectionEnd() - inputTextPane.getSelectionStart();
        if (diff == 0) {
            caretInfo.setText("Linea " + line + ", columna " + col);
        } else {
            caretInfo.setText("Linea " + line + ", columna " + col + " (" + diff + " chars)");
        }
    }

    public TextPaneWithListeners() {
        setLayout(new BorderLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(FG_LABEL, 1, true));

        UndoManager undoManager = new UndoManager();
        undoAction = new UndoManagement.Undo(undoManager);
        redoAction = new UndoManagement.Redo(undoManager);

        setAsideTextPane();
        setInputTextPane(undoManager);

        caretInfo = new JLabel("Linea ?, columna ?");
        caretInfo.setHorizontalAlignment(JLabel.RIGHT);
        caretInfo.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        caretInfo.setOpaque(true);

        JScrollPane asidePanel = new JScrollPane(asideTextPane);
        add(asidePanel, BorderLayout.LINE_START);

        JPanel noWrapPanel = new JPanel(new BorderLayout());
        noWrapPanel.add(inputTextPane);

        JScrollPane inputPanel = new JScrollPane(noWrapPanel);
        add(inputPanel, BorderLayout.CENTER);

        setScrollerStyle(inputPanel, asidePanel);
    }

    public JLabel getCaretInfo() {
        return caretInfo;
    }

    public Action getUndoAction() {
        return undoAction;
    }

    public Action getRedoAction() {
        return redoAction;
    }

    public Action getCutAction() {
        return cutAction;
    }

    public Action getCopyAction() {
        return copyAction;
    }

    public Action getPasteAction() {
        return pasteAction;
    }

    public String getText() {
        return inputTextPane.getText();
    }

    public void setText(String text) {
        inputTextPane.setText(text);
    }
}
