package edu.mooncoder.view.contracts;

import edu.mooncoder.controller.ProjectManager;
import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.view.Analysis;
import edu.mooncoder.view.Principal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public interface ProjectViewManager extends DialogsTools {
    Principal principal = new Principal();
    Analysis analysis = new Analysis();

    default void openProject(ActionEvent event) {
        File copy = getFile("Seleccionar projecto", "Copy Files", "copy");

        if (copy == null) return;
        try {
            ProjectManager project = new ProjectManager(copy);
            analysis.runUi(project);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en archivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private File[] getFiles() {
        File dir = getDirectory("Guardar Proyecto", true);
        if (dir == null) return null;

        File report = getFileAndName("reporte", dir, ".def");
        if (report == null) return null;

        File result = getFileAndName("resultado (json)", dir, ".json");
        if (result == null) return null;

        File copy = new File(dir, "workspace.copy");

        if (ProjectManager.needsChangeName(copy.getName(), dir) && !overwrite("workspace.copy")) {
            copy = getFileAndName("espacio de trabajo", dir, ".copy");
            if (copy == null) return null;
        }

        return new File[]{report, result, copy};
    }

    default void saveReport(Osrn osrn) {
        File[] files = getFiles();
        if (files == null) return;

        try {
            ProjectManager project = new ProjectManager(files[0], files[1], files[2], osrn);
            analysis.runUi(project);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en archivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    default void saveReport(String resultContent, String reportContent) {
        File[] files = getFiles();
        if (files == null) return;

        try {
            ProjectManager project = new ProjectManager(files[0], files[1], files[2], resultContent, reportContent);
            analysis.runUi(project);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en archivo", JOptionPane.ERROR_MESSAGE);
        }
    }
}
