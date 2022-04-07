package edu.mooncoder.view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Console extends JFrame {
    private static final Color FG_LABEL = new Color(171, 178, 192);
    private static final Color BG_LABEL = new Color(33, 37, 42);

    private static final Color BG_PANEL = new Color(33, 38, 43);

    private static final Color BG_BTN = new Color(61, 66, 75);
    private static final Color FG_BTN = new Color(160, 168, 180);

    private static final Font FONT_BOLD = new Font("Roboto Slab Black", Font.BOLD, 14);
    private static final Font FONT_NORMAL = new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 12);

    private static final String[] titles = {"Projecto", "Archivo", "Lexema", "Linea", "Columna", "Tipo", "Descripcion"};
    private final JTable errorsTable;

    public Console() {
        super("Consola de errores");
        addDesign();

        errorsTable = new JTable();
        errorsTable.setFillsViewportHeight(true);
        errorsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(errorsTable);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        setMinimumSize(new Dimension(450, 350));
        pack();
    }

    public void showErrors(Object[][] data) {
        DefaultTableModel tableModel = new DefaultTableModel(data, titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        errorsTable.setModel(tableModel);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void addDesign() {
        UIManager.put("ScrollBar.thumbDarkShadow", Color.LIGHT_GRAY);
        UIManager.put("ScrollBar.thumbHighlight", Color.DARK_GRAY);
        UIManager.put("ScrollBar.thumbShadow", Color.DARK_GRAY);
        UIManager.put("ScrollBar.background", Color.GRAY);
        UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
        UIManager.put("ScrollBar.track", Color.GRAY);
        UIManager.put("ScrollBar.width", 12);

        UIManager.put("TableHeader.font", FONT_BOLD);
        UIManager.put("TableHeader.background", BG_LABEL);
        UIManager.put("TableHeader.foreground", FG_LABEL);
        UIManager.put("Table.background", BG_BTN);
        UIManager.put("Table.foreground", FG_BTN);
        UIManager.put("Table.gridColor", FG_BTN);
        UIManager.put("Table.font", FONT_NORMAL);

        UIManager.put("ScrollPane.background", BG_PANEL);
        UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        UIManager.put("Panel.background", BG_PANEL);

    }
}
