package edu.mooncoder.view.contracts;

import javax.swing.*;
import java.awt.*;

public interface LookTheme {
    Color FG_LABEL = new Color(171, 178, 192);
    Color BG_LABEL = new Color(33, 37, 42);

    Color BG_INPUT = new Color(40, 44, 52);
    Color FG_INPUT = new Color(171, 178, 191);

    Color BG_PANEL = new Color(33, 38, 43);

    Color BG_BTN = new Color(61, 66, 75);
    Color FG_BTN = new Color(160, 168, 180);

    Font FONT_BOLD = new Font("Roboto Slab Black", Font.BOLD, 14);
    Font FONT_BOLDER = new Font("Roboto Slab Black", Font.BOLD, 16);
    Font FONT_NORMAL = new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 12);

    default void runUIManager() {
        UIManager.put("Table.font", FONT_NORMAL);
        UIManager.put("Button.font", FONT_BOLD);
        UIManager.put("MenuItem.font", FONT_NORMAL);
        UIManager.put("TableHeader.font", FONT_BOLD);
        UIManager.put("ToggleButton.font", FONT_BOLD);

        UIManager.put("ScrollPane.background", BG_PANEL);
        UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        UIManager.put("Panel.background", BG_PANEL);

        UIManager.put("OptionPane.background", BG_INPUT);
        UIManager.put("OptionPane.foreground", FG_INPUT);
        UIManager.put("OptionPane.messageForeground", FG_LABEL);

        UIManager.put("Label.font", FONT_NORMAL);
        UIManager.put("Label.background", BG_LABEL);
        UIManager.put("Label.foreground", FG_LABEL);

        UIManager.put("TextPane.font", FONT_NORMAL);
        UIManager.put("TextPane.background", BG_INPUT);
        UIManager.put("TextPane.foreground", FG_INPUT);
        UIManager.put("TextPane.border", BorderFactory.createEmptyBorder(5, 10, 5, 10));

        UIManager.put("ScrollBar.thumbDarkShadow", Color.LIGHT_GRAY);
        UIManager.put("ScrollBar.thumbHighlight", Color.DARK_GRAY);
        UIManager.put("ScrollBar.thumbShadow", Color.DARK_GRAY);
        UIManager.put("ScrollBar.background", Color.GRAY);
        UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
        UIManager.put("ScrollBar.track", Color.GRAY);
        UIManager.put("ScrollBar.width", 12);

        UIManager.put("ComboBox.background", BG_INPUT);
        UIManager.put("ComboBox.foreground", FG_INPUT);

        UIManager.put("List.background", BG_INPUT);
        UIManager.put("List.foreground", FG_INPUT);

        UIManager.put("TextField.background", BG_INPUT);
        UIManager.put("TextField.foreground", FG_INPUT);

        UIManager.put("TextArea.background", BG_INPUT);
        UIManager.put("TextArea.foreground", FG_INPUT);

        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.contentAreaColor ", FG_LABEL);
        UIManager.put("TabbedPane.selected", BG_PANEL);
        UIManager.put("TabbedPane.foreground", FG_LABEL);
        UIManager.put("TabbedPane.background", BG_BTN);
        UIManager.put("TabbedPane.shadow", BG_PANEL);

        UIManager.put("TableHeader.background", BG_LABEL);
        UIManager.put("TableHeader.foreground", FG_LABEL);
        UIManager.put("Table.background", BG_BTN);
        UIManager.put("Table.foreground", FG_BTN);
        UIManager.put("Table.gridColor", FG_BTN);
        UIManager.put("Table.font", FONT_NORMAL);

        UIManager.put("Button.background", BG_BTN);
        UIManager.put("Button.foreground", FG_BTN);
        UIManager.put("Button.select", Color.BLACK);
        UIManager.put("Button.focus", Color.LIGHT_GRAY);
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(5, 10, 5, 10));

        UIManager.put("MenuBar.background", BG_PANEL);
        UIManager.put("MenuBar.opaque", true);

        UIManager.put("Menu.selectionBackground", Color.GRAY);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        UIManager.put("Menu.background", BG_BTN);
        UIManager.put("Menu.foreground", FG_BTN);
        UIManager.put("Menu.opaque", true);
        UIManager.put("Menu.border", BorderFactory.createEmptyBorder(3, 5, 3, 5));

        UIManager.put("MenuItem.selectionBackground", Color.GRAY);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.background", BG_BTN);
        UIManager.put("MenuItem.foreground", FG_BTN);
        UIManager.put("MenuItem.opaque", true);
        UIManager.put("MenuItem.border", BorderFactory.createEmptyBorder(3, 5, 3, 5));

        UIManager.put("ToolBar.background", BG_PANEL);
    }
}
