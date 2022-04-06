package edu.mooncoder.controller;

import edu.mooncoder.copy.controllers.manager.StructureReader;
import edu.mooncoder.copy.model.PathFile;
import edu.mooncoder.osrn.model.containers.Osrn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class ProjectManager {
    private static final String copyContent = "json: \"%s\"\nrml: \"%s\"";
    private File report;
    private File result;

    private void createIfNotExist(File file) throws IOException {
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException();
            }
        }
    }

    public ProjectManager(File copy) throws IOException {
        if (!copy.exists()) {
            throw new IOException("El archivo escogido no existe.");
        }
        StructureReader reader = new StructureReader();
        PathFile[] files = new PathFile[0];
        try {
            files = reader.getFiles(copy.getAbsolutePath());
        } catch (Exception e) {
            throw new IOException("El espacio de trabajo fue corrompido");
        }

        Arrays.stream(files).forEach(file -> {
            if (file.filename().equals("json") && Files.exists(Path.of(file.path()))) {
                result = new File(file.path());
            }
        });
        Arrays.stream(files).forEach(file -> {
            if (file.filename().equals("rml") && Files.exists(Path.of(file.path()))) {
                report = new File(file.path());
            }
        });
        if (report == null) {
            throw new IOException("No se encontro el archivo de reportes.");
        }
        if (result == null) {
            throw new IOException("No se encontro el archivo de resultados.");
        }
    }

    public ProjectManager(File report, File result, File copy, Osrn osrn) throws IOException {
        createIfNotExist(report);
        createIfNotExist(result);
        createIfNotExist(copy);

        String copyContentFormatted = String.format(copyContent, result.getAbsolutePath(), report.getAbsolutePath());
        Files.writeString(copy.toPath(), copyContentFormatted);
        Files.writeString(result.toPath(), osrn.toString());

        this.report = report;
        this.result = result;
    }

    public ProjectManager(File report, File result, File copy, String resultContent, String reportContent) throws IOException {
        createIfNotExist(report);
        createIfNotExist(result);
        createIfNotExist(copy);

        String copyContentFormatted = String.format(copyContent, result.getAbsolutePath(), report.getAbsolutePath());
        Files.writeString(copy.toPath(), copyContentFormatted);
        Files.writeString(result.toPath(), resultContent);
        Files.writeString(report.toPath(), reportContent);

        this.report = report;
        this.result = result;
    }

    public static boolean needsChangeName(String name, File dir) {
        return Arrays.stream(Objects.requireNonNull(dir.listFiles())).anyMatch(file -> file.getName().equals(name));
    }

    public void saveProgress(String contentReport, String contentResult) throws IOException {
        Files.writeString(report.toPath(), contentReport);
        Files.writeString(result.toPath(), contentResult);
    }

    public String getReport() throws IOException {
        return Files.readString(report.toPath());
    }

    public String getResult() throws IOException {
        return Files.readString(result.toPath());
    }

    public String getReportName() {
        return report.getName();
    }

    public String getResultName() {
        return result.getName();
    }
}
