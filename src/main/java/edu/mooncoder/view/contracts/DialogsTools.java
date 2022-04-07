package edu.mooncoder.view.contracts;

import edu.mooncoder.controller.ProjectManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public interface DialogsTools {
    default boolean overwrite(String file) {
        return JOptionPane.showConfirmDialog(null, "El archivo " + file + " ya existe, ¿Desea"
                + " sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    default boolean wantToContinue(String extra) {
        return JOptionPane.showConfirmDialog(null, extra + "¿Esta seguro de que quiere continuar?",
                "Salir de la ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    default boolean wantToClose() {
        return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere salir?",
                "Salir de la ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    default boolean wantToSave() {
        return JOptionPane.showConfirmDialog(null, "¿Quiere guardar (o asegurarse de que guardo)?",
                "Guardar progreso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    default File getFileAndName(String toName, File dir, String extension) {
        String nameMsg = "¿Como quiere llamar al %s?";
        String nameTtl = "Nombrando al %s";

        String filename = JOptionPane.showInputDialog(
                null, String.format(nameMsg, toName), String.format(nameTtl, "reporte"),
                JOptionPane.INFORMATION_MESSAGE);

        while (filename != null && ProjectManager.needsChangeName(filename + extension, dir)) {
            if (overwrite(filename + extension)) break;
            filename = JOptionPane.showInputDialog(
                    null, String.format(nameMsg, toName), String.format(nameTtl, "reporte"),
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (filename == null) return null;

        return new File(dir, filename + extension);
    }

    default File getDirectory(String title, boolean save) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int approved = (save) ? fileChooser.showSaveDialog(null) : fileChooser.showOpenDialog(null);
        if (approved == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    default File getFile(String title, String explanation, String ...extension) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(explanation, extension));

        int approved = fileChooser.showOpenDialog(null);
        if (approved == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

}
